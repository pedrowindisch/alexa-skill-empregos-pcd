module.exports = (handlerInput, attr, attrValue) => {
  const sessionAttributes = handlerInput.attributesManager.getSessionAttributes();
  sessionAttributes[attr] = attrValue;
  handlerInput.attributesManager.setSessionAttributes(sessionAttributes);
}