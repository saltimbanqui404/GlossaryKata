package com.kata.glossary.domain;


import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum AikidoRank {

    FIRST_KYU,
    SECOND_KYU,
    THIRD_KYU,
    FOURTH_KYU,
    FIFTH_KYU,
    SIXTH_KYU,
    FIRST_DAN,
    SECOND_DAN,
    THIRD_DAN,
    FOURTH_DAN,
    FIFTH_DAN,
    SIXTH_DAN,
    SEVENTH_DAN,
    EIGHTH_DAN;

    private static final Map<String, AikidoRank> stringToEnum =
            Stream.of(AikidoRank.values()).collect(
                    toMap(Object::toString, e -> e));

    public static AikidoRank fromString(String rank){
        return stringToEnum.get(rank);
    }

    public AikidoRank getHigherOrEqualRank (AikidoRank targetRank) {
        return this.compareTo(targetRank) > 0 ?  targetRank : this;
    }

}
