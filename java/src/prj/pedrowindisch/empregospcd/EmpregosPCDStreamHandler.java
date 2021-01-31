package prj.pedrowindisch.empregospcd;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.empregospcd.handlers.*;
import io.github.cdimascio.dotenv.Dotenv;
import prj.pedrowindisch.empregospcd.handlers.*;

public class EmpregosPCDStreamHandler extends SkillStreamHandler {
    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallBackIntentHandler())
                .withSkillId(System.getProperty("SKILL_ID"))
                .build();
    }

    public EmpregosPCDStreamHandler() {
        super(getSkill());

        // Carrega as variáveis do sistema a partir do .env na raíz do projeto.
        // Atualizar a key da API e o código da skill por lá se for preciso.
        Dotenv.configure().systemProperties().load();
    }
}
