package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.enums.HallTypeEnum;

@Getter
@Setter
@NoArgsConstructor

public class HallDTO {

    private Long id;

    private int numberHall;

    private int maxNumberPlace;

    private HallTypeEnum hallType;

}
