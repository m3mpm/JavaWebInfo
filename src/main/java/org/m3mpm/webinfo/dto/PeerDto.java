package org.m3mpm.webinfo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PeerDto {

    @NotBlank(message = "Nickname is required and cannot be empty.")
    private String nickname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthday must be in the past.")
    @NotNull(message = "Birthday is required.")
    private LocalDate birthday;

    public PeerDto() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PeerDto{" +
                "nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
