const ProcurarVagasIntentHandler = require("./procurarVagasIntentHandler");
const SessionEndedRequestHandler = require("./sessionEndedRequestHandler");
const CancelAndStopIntentHandler = require("./cancelAndStopIntentHandler");
const IntentReflectorHandler = require("./intentReflectorHandler");
const FallbackIntentHandler = require("./fallbackIntentHandler");
const LaunchRequestHandler = require("./launchRequestHandler");
const HelpIntentHandler = require("./helpIntentHandler");
const YesIntentHandler = require("./yesIntentHandler");
const NoIntentHandler = require("./noIntentHandler");

module.exports = [
  ProcurarVagasIntentHandler,
  SessionEndedRequestHandler,
  CancelAndStopIntentHandler,
  IntentReflectorHandler,
  FallbackIntentHandler,
  LaunchRequestHandler,
  HelpIntentHandler,
  YesIntentHandler,
  NoIntentHandler
]