package com.engine.realestatesearchapp.utilities.specifications;

import com.engine.realestatesearchapp.repositiories.entities.RealEstate;
import com.engine.realestatesearchapp.repositiories.entities.RealEstate_;
import com.engine.realestatesearchapp.utilities.filters.RealEstateQueryFilters;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateSpecifications {

    public static Specification<RealEstate> getRealEstateSpecification(RealEstateQueryFilters filters) {
        Specification<RealEstate> specification = Specification.where(null);
/*        if (filters.getCategory() != null) {
            specification = specification.and(categoryEquals(filters.getCategory()));
        }
        if (filters.getOfferType() != null) {
            specification = specification.and(offerTypeEquals(filters.getOfferType()));
        }*/
        if (filters.getCreatedAtFrom() != null) {
            specification = specification.and(createdAtGreaterThanOrEqualTo(filters.getCreatedAtFrom()));
        }
        if (filters.getCreatedAtTo() != null) {
            specification = specification.and(createdAtLessThanOrEqualTo(filters.getCreatedAtTo()));
        }
        return specification;
    }

/*    public static Specification<RealEstate> categoryEquals(RealEstateCategory category) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(RealEstate_.ID), category);
    }

    public static Specification<RealEstate> offerTypeEquals(OfferType offerType) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(RealEstate_.ID), offerType);
    }*/

    public static Specification<RealEstate> createdAtGreaterThanOrEqualTo(LocalDateTime createdAtFrom) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(RealEstate_.CREATED_AT), createdAtFrom);
    }

    public static Specification<RealEstate> createdAtLessThanOrEqualTo(LocalDateTime createdAtTo) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(RealEstate_.CREATED_AT), createdAtTo);
    }

}
