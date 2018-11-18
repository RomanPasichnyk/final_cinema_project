package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.enums.HallTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "halls")
public class HallEntity extends BaseEntity {

    @Column(name = "number_hall", nullable = false, unique = true)
    private int numberHall;

    @Column(name = "max_number_place", nullable = false)
    private int maxNumberPlace;

    @Enumerated
    private HallTypeEnum hallType;


}
