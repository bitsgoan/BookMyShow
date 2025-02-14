package repositories;

import com.scaler.bookmyshowscaler.models.ShowSeatType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.bookmyshowscaler.models.Show;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

        List<ShowSeatType> findAllByIdEquals(Show show);
}
