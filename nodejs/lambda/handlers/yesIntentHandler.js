const Alexa = require('ask-sdk-core');

const { getSessionAttr } = require("../helpers");

module.exports = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
      && Alexa.getIntentName(handlerInput.requestEnvelope) === 'AMAZON.YesIntent';
  },
  handle(handlerInput) {
    const speechTexts = getSessionAttr(handlerInput, "jobOpeningsSpeechTexts");

    let message =
      speechTexts.length > 1 ? "Aqui estão minhas sugestões: " : "Aqui está minha sugestão: ";

    for (let speechText of speechTexts) message += speechTexts;

    return handlerInput.responseBuilder
      .speak(message)
      .withShouldEndSession(true)
      .getResponse();
  }
}