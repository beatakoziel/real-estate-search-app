package com.engine.realestatesearchapp.repositiories.entities;

import com.engine.realestatesearchapp.repositiories.enums.OfferType;
import com.engine.realestatesearchapp.repositiories.enums.RealEstateCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "REAL_ESTATE")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "RealEstate.details",
        attributeNodes = {
                @NamedAttributeNode("localization"),
                @NamedAttributeNode("files"),
        })
@Where(clause = "deleted = false")
@EntityListeners(AuditingEntityListener.class)
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false, length = 1024)
    private String description;

    @Column(name = "COMMENT", length = 1024)
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", nullable = false)
    private RealEstateCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "OFFER_TYPE", nullable = false)
    private OfferType offerType;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "SIZE", nullable = false)
    private BigDecimal size;

    @Column(name = "DELETED")
    private boolean deleted;

    @Column(name = "VISITS_COUNTER")
    private int visitsCounter;

    @Column(name = "PHONE_VIEWS_COUNTER")
    private int phoneViewsCounter;

    @Column(name = "SOLD")
    private boolean sold;

    @Column(name = "BANNED")
    private boolean banned;

    @Column(name = "REAL_ESTATE_ID")
    private UUID realEstateId;

    @ManyToOne
    private Localization localization;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "realEstateOffer", fetch = FetchType.LAZY)
    private List<File> files;

    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void setOfferType(String s) {
    }
}
