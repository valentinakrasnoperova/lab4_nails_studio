package nailsstudio.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nailsstudio.entity.enumeration.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message ="you should enter your name")
    @Pattern(regexp="([A-Z][a-z]{2,})", message="Invalid name, please use only latin letters")
    private String name;

    @NotBlank(message ="you should enter your surname")
    @Pattern(regexp="([A-Z][a-z]{2,})", message="Invalid surname, please use only latin letters")
    private String surname;

    @Email
    @NotBlank(message ="you should enter your email")
    private String email;

    @NotBlank(message ="you should enter your birth date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birthDate;

    private UserRole role;
}