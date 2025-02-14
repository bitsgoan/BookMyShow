package services;

import com.scaler.bookmyshowscaler.models.Show;
import com.scaler.bookmyshowscaler.models.ShowSeat;
import com.scaler.bookmyshowscaler.models.ShowSeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ShowSeatTypeRepository;

import java.util.List;

@Service
public class TicketPriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public TicketPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateTicketPrice(List<ShowSeat> showSeats) {
        // 1. GetShowSeatType objects
        Show show = showSeats.getFirst().getShow();
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByIdEquals(show);

        // 2. Add their prices and return
        double amount = 0;
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType: showSeatTypes){
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
