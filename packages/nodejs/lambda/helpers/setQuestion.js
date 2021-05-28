const setSessionAttr = require("./setSessionAttr");

module.exports = (handlerInput, questionAsked) => {
  setSessionAttr(handlerInput, "questionAsked", questionAsked);
}