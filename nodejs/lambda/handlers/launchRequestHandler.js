const Alexa = require('ask-sdk-core');

module.exports = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'LaunchRequest';
  },
  handle(handlerInput) {
    const welcomeMessage =
      "Olá! " +
      "Para encontrar vagas PCD perto de você, por favor me diga sua cidade.";

    const repromptMessage =
      "Por favor, me diga a cidade que você quer procurar vagas."

    return handlerInput.responseBuilder
      .speak(welcomeMessage)
      .reprompt(repromptMessage)
      .getResponse();
  }
};