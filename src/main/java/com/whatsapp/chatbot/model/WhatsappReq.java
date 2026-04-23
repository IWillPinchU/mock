package com.whatsapp.chatbot.model;

import jakarta.validation.constraints.NotBlank;

public record WhatsappReq(
 
  @NotBlank(message = "Sender 'from' must not be blank")
  String from,
 
  @NotBlank(message = "Message 'msg' must not be blank")
  String msg
) {}
