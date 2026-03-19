package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for creating or updating advertisement")
public class AdvertisementRequestDto {

    @NotBlank
    @Size(max = 120)
    @Schema(description = "Advertisement title", example = "Продаю горный велосипед")
    private String title;

    @NotBlank
    @Size(max = 2000)
    @Schema(description = "Advertisement description", example = "В хорошем состоянии, использовался один сезон")
    private String description;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Category name", example = "Спорттовары")
    private String category;

    @NotNull
    @PositiveOrZero
    @DecimalMin(value = "0.0", inclusive = true)
    @Schema(description = "Price", example = "25000")
    private BigDecimal price;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Seller display name", example = "Владимир")
    private String sellerName;

    @NotBlank
    @Email
    @Size(max = 255)
    @Schema(description = "Seller email", example = "seller@example.com")
    private String contactEmail;

    @Size(max = 30)
    @Schema(description = "Seller phone", example = "+7 (999) 123-45-67")
    private String contactPhone;
}
