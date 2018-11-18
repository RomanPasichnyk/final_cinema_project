package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.enums.AccessEnum;
import ua.logos.enums.GenderEnum;
import ua.logos.enums.GenreEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", length = 13, unique = true, nullable = false)
    private String phoneNumber;

    @Enumerated
    private GenreEnum favoriteGenre;

    @Enumerated
    private AccessEnum access;

    @Column(name = "image")
    private String image;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @Enumerated
    private GenderEnum gender;

}
