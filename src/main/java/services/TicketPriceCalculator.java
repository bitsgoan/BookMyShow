package services;

import com.scaler.bookmyshowscaler.models.Show;
import com.scaler.bookmyshowscaler.models.ShowSeat;
import com.scaler.bookmyshowscaler.models.ShowSeatType;
import lombok.AllArgsConstructor;
import repositories.ShowSeatTypeRepository;

import java.util.List;

@AllArgsConstructor
public class TicketPriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    private double calculateTicketPrice(List<ShowSeat> showSeats) {
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
