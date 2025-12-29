package org.akimoved.bookings.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "aircrafts", schema = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    @Id
    @Column(name = "aircraft_code", length = 3, nullable = false)
    private String aircraftCode;

    @Column(name = "model", nullable = false, columnDefinition = "TEXT")
    private String model;

    @Column(name = "range", nullable = false)
    private Integer range;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights;
}