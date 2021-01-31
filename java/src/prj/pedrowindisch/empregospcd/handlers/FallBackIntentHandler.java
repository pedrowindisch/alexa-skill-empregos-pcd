package prj.pedrowindisch.empregospcd.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallBackIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Perdão. Não entendi o que você quis dizer. Por favor, repita.";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Empregos PCD", speechText)
                .withReprompt(speechText)
                .build();
    }

}
