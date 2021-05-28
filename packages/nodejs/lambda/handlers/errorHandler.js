module.exports = {
  canHandle() {
    return true;
  },
  handle(handlerInput, error) {
    const speakOutput = 'Ocorreu um erro.';
    console.log(`~~~~ Erro: ${JSON.stringify(error)}`);

    return handlerInput.responseBuilder
      .speak(speakOutput)
      .reprompt(speakOutput)
      .getResponse();
  }
}