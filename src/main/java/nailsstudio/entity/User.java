package nailsstudio.entity;

import nailsstudio.entity.enumeration.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private UserRole role;
}