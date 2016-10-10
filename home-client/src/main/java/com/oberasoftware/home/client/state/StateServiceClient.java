package com.oberasoftware.home.client.state;

import com.oberasoftware.home.api.impl.state.StateImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Renze de Vries
 */
@Component
public class StateServiceClient {
    private static final Logger LOG = LoggerFactory.getLogger(StateServiceClient.class);

    @Value("${state_svc_url}")
    private String stateServiceUrl;

    private WebSocketStompClient stompClient;

    public void connect() {
        LOG.info("Connecting to State websocket endpoint: {}", getStateServiceUrl());
//        WebSocketClient webSocketClient = new StandardWebSocketClient();
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport( new StandardWebSocketClient()));
        WebSocketClient transport = new SockJsClient(transports);

        stompClient = new WebSocketStompClient(transport);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MySessionHandler();
        stompClient.connect(getStateServiceUrl(), sessionHandler);
    }

    public void disconnect() {
        LOG.info("Disconnect websocket client");
        stompClient.stop();
    }

    private String getStateServiceUrl() {
        String url = stateServiceUrl;
        if(!url.endsWith("/")) {
            url += "/";
        }
        return url + "ws";
    }

    private class MySessionHandler extends StompSessionHandlerAdapter {
        @Override
        public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
            LOG.info("Connected to state service");
            session.subscribe("/topic/state", new StompFrameHandler() {
                @Override
                public Type getPayloadType(StompHeaders stompHeaders) {
                    return StateImpl.class;
                }

                @Override
                public void handleFrame(StompHeaders stompHeaders, Object o) {
                    LOG.info("Received a state message: {}", o);
                }
            });
        }



        @Override
        public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
            LOG.error("Something went wrong?: {}, {}", exception, headers.getContentType());
        }

        @Override
        public void handleTransportError(StompSession session, Throwable exception) {
            LOG.error("IEK", exception);
        }
    }
}
