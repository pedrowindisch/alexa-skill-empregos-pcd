package prj.pedrowindisch.empregospcd.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.empregospcd.util.*;
import com.amazon.ask.model.Response;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import prj.pedrowindisch.empregospcd.util.EmpregosUtil;
import prj.pedrowindisch.empregospcd.util.SessionAttributesUtil;

import java.io.IOException;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ProcurarVagasIntentHandler implements RequestHandler {
    private static final int JOB_OPENINGS_PER_REQUEST = 3;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("ProcurarVagasIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String location = SessionAttributesUtil.getRequestSlotsValues(input).get("cidade").toString();
        JsonArray jobs;

        try {
            jobs = EmpregosUtil.fetchJobsList(location);
        } catch (IOException e) {
            return input.getResponseBuilder()
                    .withSpeech(String.format("Não consegui encontrar vagas em %s", location))
                    .build();
        }

        String jobsText = "";
        for(int i = 0; i < JOB_OPENINGS_PER_REQUEST; i++) {
            JsonObject currentJobOpening = jobs.get(i).getAsJsonObject();
            JsonElement jobTitle = currentJobOpening.get("title");
            JsonElement jobCompany = currentJobOpening.get("company");

            if(jobTitle == null || jobCompany == null) continue;

            jobsText += jobTitle.toString() + ", na empresa " + jobCompany.toString() + ".";
        }

        String speechText = "Aqui estão minhas sugestões: " + jobsText;

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Veja minhas sugestões", speechText)
                .build();
    }
}
