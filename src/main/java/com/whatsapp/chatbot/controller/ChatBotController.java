package com.whatsapp.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.chatbot.dto.ResponseDTO;
import com.whatsapp.chatbot.model.WhatsappReq;
import com.whatsapp.chatbot.service.ChatBotService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
@Slf4j
public class ChatBotController {

  private final ChatBotService chatBotService;

  @PostMapping
  public ResponseEntity<ResponseDTO> chatBot(@RequestBody @Valid WhatsappReq req) {
    log.info("Request Received in controller layer from " + req.from() + "with message" + req.msg());
    ResponseDTO response = chatBotService.processMsg(req);
    log.info("Replying to Request from " + req.from() + "with reply " + response.reply() + "with status code ok (200)");
    return ResponseEntity.ok(response);
  }
}
