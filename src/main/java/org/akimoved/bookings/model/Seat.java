package org.akimoved.bookings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seats", schema = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SeatId.class)
public class Seat {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Id
    @Column(name = "seat_no", length = 4, nullable = false)
    private String seatNo;

    @Column(name = "fare_conditions", length = 10, nullable = false)
    private String fareConditions;
}
