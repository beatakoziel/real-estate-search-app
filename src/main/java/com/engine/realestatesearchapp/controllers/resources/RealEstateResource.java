package com.engine.realestatesearchapp.controllers.resources;

import com.engine.realestatesearchapp.repositiories.entities.Localization;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "RealEstateResource", description = "Real estate details")
public class RealEstateResource extends RepresentationModel<RealEstateResource> {
    private UUID basicInfoId;
    private UUID realEstateId;
    private String title;
    private String description;
    private String category;
    private String comment;
    private BigDecimal price;
    private BigDecimal size;
    private BigDecimal rent;
    private Boolean furnished;
    private Short roomsNumber;
    private BigDecimal plotSize;
    private Short floorsNumber;
    private Short floorNumber;
    private String offerType;
    private UUID localizationId;
    private String plotType;
    private String roomType;
    private String houseType;
    private String flatType;
    private String premisesPurpose;
    private boolean favourite;
    private boolean sold;
    private boolean banned;
    private int visitsCounter;
    private int phoneViewsCounter;
    private Localization localization;
    private List<FileResource> files;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserResource user;
}
