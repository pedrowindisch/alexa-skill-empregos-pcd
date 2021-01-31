package prj.pedrowindisch.empregospcd.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Oi, tudo bem? Sou uma skill que vai te ajudar a encontrar vagas para pessoas " +
                            "com deficiência na sua área. Você só precisa me dizer onde você quer buscar uma vaga " +
                            "que eu irei te recomendar até três vagas perto de você." +
                            "Vamos buscar vagas? Para começar, por favor me diga a sua cidade.";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Vamos começar?", speechText)
                .withReprompt(speechText)
                .build();
    }

}
