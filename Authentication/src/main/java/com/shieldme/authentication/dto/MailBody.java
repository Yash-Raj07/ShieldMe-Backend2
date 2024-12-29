package com.shieldme.authentication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.attribute.FileTime;

@Getter
@Setter
@Builder
public class MailBody {
    private String to;
    private String text;
    private String subject;

    public static FileTime builder() {
        return builder();
    }
}
