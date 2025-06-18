package ru.sberhack2025.companyevents.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Andrey Kurnosov
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDto {

    @Schema(description = "User's name", example = "Маша")
    String name;

}
