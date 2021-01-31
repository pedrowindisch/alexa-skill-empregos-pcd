package prj.pedrowindisch.empregospcd.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Slot;

import java.util.Map;

public class SessionAttributesUtil {
    public static Map<String, Slot> getRequestSlotsValues(HandlerInput input) {
        IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
        return intentRequest.getIntent().getSlots();
    }

    public static void setSessionAttribute(HandlerInput input, String attr, String attrValue) {
        Map<String, Object> currentSessionAttrs = input.getAttributesManager().getSessionAttributes();

        currentSessionAttrs.put(attr, attrValue);
    }

    public static Object getSessionAttributes(HandlerInput input, String attr) {
        Map<String, Object> currentSessionAttrs = input.getAttributesManager().getSessionAttributes();

        return currentSessionAttrs.get(attr);
    }

    public static Map<String, Object> getSessionAttributes(HandlerInput input) {
        return input.getAttributesManager().getSessionAttributes();
    }
}
