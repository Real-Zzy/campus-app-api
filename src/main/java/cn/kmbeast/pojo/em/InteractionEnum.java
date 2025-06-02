package cn.kmbeast.pojo.em;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InteractionEnum {

    SAVE(1, "Favorite"),
    VIEW(2, "Viewed"),
    LOVE(3, "Wanted");

    /**
     * Status
     */
    private final Integer type;
    /**
     * Status Detail
     */
    private final String detail;


}