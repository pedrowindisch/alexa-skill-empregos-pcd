package prj.pedrowindisch.empregospcd.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String title = "Empregos PCDs";
        String speechText = "Olá! Para encontrar vagas PCD perto de você, " +
                            "por favor me diga sua cidade.";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(title, speechText)
                .withReprompt(speechText)
                .build();
    }
}
