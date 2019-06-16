package ua.diploma.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.diploma.enums.GenderEnum;
import ua.diploma.enums.GenreEnum;
import ua.diploma.validation.CheckAgeCorrect;
import ua.diploma.validation.CheckEmailCorrect;
import ua.diploma.validation.CheckPhoneNumberCorrect;
import ua.diploma.validation.CheckPhoneNumberExists;
import ua.diploma.validation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {

    private Long id;

    @CheckEmailCorrect
//    @CheckEmailExists
    @NotNull(message = "Field email can`t be null")
    @Size(min = 6, max = 40, message = "[Email]: Min length 6 symbols, max length 40 symbols")
    private String email;

    @NotNull
    private String password;

    private String confirmPassword;

    @Size(max = 40, message = "Max length 40 symbols")
    private String name;

    @CheckAgeCorrect
    private int age;

    @CheckPhoneNumberCorrect
    @CheckPhoneNumberExists
    private String phoneNumber;

    private GenreEnum favoriteGenre;

    private String image;

    private LocalDate birthDate;

    private GenderEnum gender;

}
