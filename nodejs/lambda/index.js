const Alexa = require('ask-sdk-core');

const ErrorHandler = require("./handlers/errorHandler");
const handlers = require("./handlers");

exports.handler = 
  Alexa
    .SkillBuilders
    .custom()
    .addRequestHandlers(
        ...handlers
    ).addErrorHandlers(
        ErrorHandler
    ).withCustomUserAgent('dev/empregos-pcd/v1')
    .lambda();