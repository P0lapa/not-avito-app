package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for advertisement response")
public class AdvertisementResponseDto {

    @Schema(description = "Advertisement identifier", example = "1")
    private Long id;

    @Schema(description = "Advertisement title", example = "Продаю горный велосипед")
    private String title;

    @Schema(description = "Advertisement description")
    private String description;

    @Schema(description = "Category name", example = "Спорттовары")
    private String category;

    @Schema(description = "Price", example = "25000")
    private BigDecimal price;

    @Schema(description = "Seller display name", example = "Владимир")
    private String sellerName;

    @Schema(description = "Seller email", example = "seller@example.com")
    private String contactEmail;

    @Schema(description = "Seller phone", example = "+7 (999) 123-45-67")
    private String contactPhone;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;

    @Schema(description = "Update timestamp")
    private LocalDateTime updatedAt;
}
