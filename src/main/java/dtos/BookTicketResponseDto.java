package dtos;

import com.scaler.bookmyshowscaler.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private String status;
    private Ticket ticket;
}
