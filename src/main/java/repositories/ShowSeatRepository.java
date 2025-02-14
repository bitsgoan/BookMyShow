package repositories;

import com.scaler.bookmyshowscaler.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
        List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);
    }
