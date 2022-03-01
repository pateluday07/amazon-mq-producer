package com.pateluday07.amazonmq.producer.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    @NotBlank(message = "Please enter message!")
    private String message;
}
