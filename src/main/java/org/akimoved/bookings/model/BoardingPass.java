package org.akimoved.bookings.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "boarding_passes", schema = "bookings",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"flight_id", "boarding_no"}),
                @UniqueConstraint(columnNames = {"flight_id", "seat_no"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BoardingPassId.class)
public class BoardingPass {

    @Id
    @Column(name = "ticket_no", length = 13, nullable = false)
    private String ticketNo;

    @Id
    @Column(name = "flight_id", nullable = false)
    private Integer flightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no", insertable = false, updatable = false)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    private TicketFlight ticketFlight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    private Flight flight;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", length = 4, nullable = false)
    private String seatNo;
}
