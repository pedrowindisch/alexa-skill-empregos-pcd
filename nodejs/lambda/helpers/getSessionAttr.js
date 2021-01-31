module.exports = (handlerInput, attr) => {
  const sessionAttributes = handlerInput.attributesManager.getSessionAttributes();
  return sessionAttributes[attr];
}