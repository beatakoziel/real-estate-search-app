package com.engine.realestatesearchapp.controllers;

import com.engine.realestatesearchapp.controllers.requests.RealEstateRequest;
import com.engine.realestatesearchapp.controllers.resources.RealEstateResource;
import com.engine.realestatesearchapp.repositiories.entities.RealEstate;
import com.engine.realestatesearchapp.repositiories.entities.RealEstateTypes;
import com.engine.realestatesearchapp.repositiories.enums.FlatType;
import com.engine.realestatesearchapp.repositiories.enums.HouseType;
import com.engine.realestatesearchapp.repositiories.enums.OfferType;
import com.engine.realestatesearchapp.repositiories.enums.PlotType;
import com.engine.realestatesearchapp.repositiories.enums.PremisesPurpose;
import com.engine.realestatesearchapp.repositiories.enums.RealEstateCategory;
import com.engine.realestatesearchapp.repositiories.enums.RoomType;

public class CommonAssembler {

    public static RealEstate mapToEntity(RealEstateRequest request) {
        RealEstateTypes types = mapToRealEstateTypes(request);
        RealEstate entity = mapToRealEstateEntity(request);
        entity.setTypes(types);
        return entity;
    }

    public static RealEstateResource mapToResource(RealEstate entity) {
        return RealEstateResource.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .rent(entity.getRent())
                .size(entity.getSize())
                .roomsNumber(entity.getRoomsNumber())
                .floors(entity.getFloors())
                .furnished(entity.getFurnished())
                .sold(entity.isSold())
                .category(entity.getTypes().getCategory())
                .offerType(entity.getTypes().getOfferType())
                .houseType(entity.getTypes().getHouseType())
                .roomType(entity.getTypes().getRoomType())
                .plotType(entity.getTypes().getPlotType())
                .flatType(entity.getTypes().getFlatType())
                .premisesPurpose(entity.getTypes().getPremisesPurpose())
                .build();
    }

    private static RealEstate mapToRealEstateEntity(RealEstateRequest request) {
        return RealEstate.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .rent(request.getRent())
                .size(request.getSize())
                .roomsNumber(request.getRoomsNumber())
                .floors(request.getFloors())
                .furnished(request.isFurnished())
                .deleted(false)
                .sold(false)
                .build();
    }

    private static RealEstateTypes mapToRealEstateTypes(RealEstateRequest request) {
        return RealEstateTypes.builder()
                .category(RealEstateCategory.valueOfLabel(request.getCategory()))
                .offerType(OfferType.valueOfLabel(request.getOfferType()))
                .houseType(HouseType.valueOfLabel(request.getHouseType()))
                .roomType(RoomType.valueOfLabel(request.getRoomType()))
                .plotType(PlotType.valueOfLabel(request.getPlotType()))
                .flatType(FlatType.valueOfLabel(request.getFlatType()))
                .premisesPurpose(PremisesPurpose.valueOfLabel(request.getPremisesPurpose()))
                .build();
    }
}