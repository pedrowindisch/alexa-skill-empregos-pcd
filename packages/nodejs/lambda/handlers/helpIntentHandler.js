const Alexa = require('ask-sdk-core');

module.exports = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
      && Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.HelpIntent';
  },
  handle(handlerInput) {
    const speakOutput =
      "Oi, tudo bem? Sou uma skill que vai te ajudar a encontrar vagas para pessoas " +
      "com deficiência na sua área. Você só precisa me dizer onde você quer buscar uma vaga e, por favor, " +
      "informe o nome de uma cidade, que eu irei te recomendar até três vagas perto de você." +
      "Vamos buscar vagas? Para começar, por favor me diga a sua cidade.";

    return handlerInput.responseBuilder
      .speak(speakOutput)
      .reprompt(speakOutput)
      .getResponse();
  }
}