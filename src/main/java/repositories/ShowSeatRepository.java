package repositories;

import com.scaler.bookmyshowscaler.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
        @Lock(LockModeType.PESSIMISTIC_WRITE)
        List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);
    }
