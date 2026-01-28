package com.example.tictactoe.websocket;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Websocket;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameWebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message) throws Exception {
        String payload = message.getPayload();

        String response = "Echo: " + payload;

        session.sendMessage(new TextMessage(response));
    }
}
