package services;

import com.scaler.bookmyshowscaler.models.*;
import lombok.AllArgsConstructor;
import repositories.ShowRepository;
import repositories.ShowSeatRepository;
import java.util.Date;

import java.util.List;

@AllArgsConstructor
public class TicketService {

    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    public Ticket bookTicket(Long showId, List<Long> showSeatIds){
        // 1. Get show from the ID.
        Show show = showRepository.findByIdEquals(showId);

        // 2. Get show seats from the ID.
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // 3. Lock the tickets seats if available and validations made.
        // 4b. Throw and exception if not available.
        for (ShowSeat showSeat : showSeats){
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Show seats not available");
            }
        }

        for (ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        // 4a. Create a ticket and save to DB.
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PAYMENT_DUE);
        ticket.setBookingTime(new Date());
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setAmount(TicketPriceCalculator.calculateTicketPrice(showSeats));


        // 5. If 4a, then redirect for payments.

        return ticket;
    }
}
