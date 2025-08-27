package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[A-Z]).{8,}$";
    @NotBlank
    private String oldPassword;
    @NotBlank
    @Size(min = 8, message = "새 비밀번호는 8자 이상이어야 합니다")
    @Pattern(regexp = PASSWORD_REGEX, message = "새 비밀번호는 숫자와 대문자를 포함해야 합니다.")
    private String newPassword;
}
