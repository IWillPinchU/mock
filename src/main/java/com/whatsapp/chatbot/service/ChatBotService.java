package com.whatsapp.chatbot.service;

import org.springframework.stereotype.Service;

import com.whatsapp.chatbot.dto.ResponseDTO;
import com.whatsapp.chatbot.model.WhatsappReq;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatBotService {
  public ResponseDTO processMsg(WhatsappReq req) {
    log.info("Request Received in service layer from " + req.from() + "with message" + req.msg());
    String reply = switch (req.msg().trim().toLowerCase()) {
      case "hi" -> "Hello";
      case "bye" -> "Goodbye";
      default -> "Outside of my scope";
    };
    log.info("Replying to Request from " + req.from() + "with reply" + reply);
    return new ResponseDTO(reply);
  }
}
