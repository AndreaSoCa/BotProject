package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "yeyelin_bot";
    public static final String TOKEN = "6668906189:AAEV4QujHqgROPTSGVOhufhF7n8HcV43bgU";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Bienvenido");
        }

        if (getMessageText().contains("Hola")){
            sendTextMessageAsync("¿Cuál es tu nombre?");
        }

        if (getMessageText().contains("Me llamo")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}