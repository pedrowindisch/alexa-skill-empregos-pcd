const Alexa = require('ask-sdk-core');
const dotenv = require('dotenv');

const ErrorHandler = require("./handlers/errorHandler");
const handlers = require("./handlers");

// Carrega as variáveis de ambiente
dotenv.config();

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