# Alexa Skill - Empregos PCD

Skill feita para o [Prêmio Alexa de Acessibilidade](https://developer.amazon.com/pt-BR/alexa/alexa-skills-kit/premio-alexa-de-acessibilidade).

Ao ser chamada, a skill fornece até três vagas de empregos, destinadas a pessoas com deficiência, em uma região ou
cidade escolhida pelo usuário.

A skill usa a API da [Jooble](https://br.jooble.org/api/about) para realizar a busca.

A versão final da skill foi portada para Node.js para cumprir os requerimentos da premiação.

## Testar localmente

Para testar a skill localmente, registre uma chave na API da Jooble (link acima) e a adicione nas variáveis do ambiente como JOOBLE_API_KEY ou crie um arquivo .env seguindo o exemplo na raíz do projeto. Instale o pacote ask-cli com o npm: `npm install -g ask-cli`.

Acesse o diretório `alexa-skill-empregos-pcd/packages/nodejs` e rode o comando `ask configure`. Faça o login com sua conta Amazon na página que abrir e retorne ao terminal.

Inicie a sessão de debug com o comando `ask run`, e, no mesmo diretório, rode `ask dialog --locale=pt-BR`, que irá abrir um terminal REPL. Nesse terminal, você poderá interagir com a skill com comandos escritos. Use os comandos abaixo para testar a skill.

## Exemplos de comandos

> Alexa, abra Empregos PCD e encontre vagas em Blumenau. <br />
> -> Aqui estão minhas sugestões: ...

> Alexa, abra Empregos PCD <br />
> -> Olá! Para encontrar vagas perto de você, por favor me diga sua cidade. <br />
> Porto Alegre. <br />
> -> Aqui estão minhas sugestões: ... <br />
