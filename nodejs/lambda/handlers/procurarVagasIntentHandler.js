const Alexa = require('ask-sdk-core');

const { fetchJobOpenings, setSessionAttr } = require("../helpers");

const generateJobOpeningsSpeechTexts = (openings) => {
  const speechTexts = [];
  let lastCompany = "";

  for (const opening of openings) {
    if (opening.company === undefined || opening.title === undefined) continue;

    const isNewCompany = (lastCompany != opening.company);
    lastCompany = opening.company;

    let speechText = `${opening.title}, ${isNewCompany ? "" : "também"} em ${opening.company}`;
    speechTexts.push(speechText)
  }

  return speechTexts;
}

module.exports = {
  canHandle(handlerInput) {
    return Alexa.getRequestType(handlerInput.requestEnvelope) === 'IntentRequest'
      && Alexa.getIntentName(handlerInput.requestEnvelope) === 'ProcurarVagasIntent';
  },
  handle(handlerInput) {
    const cidade = Alexa.getSlotValue(handlerInput.requestEnvelope, "cidade");

    return fetchJobOpenings(cidade)
      .then(generateJobOpeningsSpeechTexts)
      .then(speechTexts => {
        if (!speechTexts.length) throw new Error("Não foram encontradas vagas.")

        setSessionAttr(handlerInput, "jobOpeningsSpeechTexts", speechTexts);

        return handlerInput.responseBuilder
          .speak(`Encontrei ${speechTexts.length > 1 ? "algumas vagas" : "uma vaga"}. Você quer ver?`)
          .withShouldEndSession(false)
          .getResponse();
      })
      .catch((err) => {
        return handlerInput.responseBuilder
          .speak(err.message)
          .getResponse()
      })
  }
}