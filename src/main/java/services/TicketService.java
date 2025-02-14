package services;

import com.scaler.bookmyshowscaler.models.*;
import exceptions.SeatNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ShowRepository;
import repositories.ShowSeatRepository;
import repositories.TicketRepository;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private TicketPriceCalculator ticketPriceCalculator;

    @Autowired
    public TicketService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository, TicketPriceCalculator ticketPriceCalculator){
        this.ticketRepository = ticketRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketPriceCalculator = ticketPriceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds) throws SeatNotAvailableException {
        // 1. Get show from the ID.
        Show show = showRepository.findByIdEquals(showId);

        // 2. Get show seats from the ID.
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // 3. Lock the tickets seats if available and validations made.
        // 4b. Throw and exception if not available.
        for (ShowSeat showSeat : showSeats){
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Seats not available for the show.");
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
        ticket.setAmount(ticketPriceCalculator.calculateTicketPrice(showSeats));
        ticketRepository.save(ticket);
        return ticket;
    }
}
