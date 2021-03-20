package org.hglteam.service.holiday.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class CORelativeToEasterArgument {
    private Integer daysAfterEaster;
    private Boolean applyEmiliany;
}
