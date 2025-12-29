package org.akimoved.bookings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPassId implements Serializable {
    private String ticketNo;
    private Integer flightId;
}
