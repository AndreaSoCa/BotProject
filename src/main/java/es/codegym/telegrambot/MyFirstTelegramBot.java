package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "yeyelin_bot";
    public static final String TOKEN = "6668906189:AAEV4QujHqgROPTSGVOhufhF7n8HcV43bgU";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20", "step_2_btn",
                            "¡Tomar un pescado! +20", "step_2_btn",
                            "¡Tirar lata de pepinillos! +20", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("¡Romper al robot aspiradora!", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot a por comida! +30", "step_4_btn",
                            "Dar un paseo en el robot aspiradora! +30", "step_4_btn",
                            "¡Huir del robot aspiradora! +30", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("¡Póntela y enciéndela!", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("¡Jugar con estambre! +40", "step_6_btn",
                            "¡Dar un paseo en el robot aspiradora! +40", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡Hackea la contraseña de la computadora!", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("¡Recta final!", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(30);
            sendTextMessageAsync(FINAL_TEXT);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}