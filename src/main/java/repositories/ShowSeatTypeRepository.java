package repositories;

import com.scaler.bookmyshowscaler.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.bookmyshowscaler.models.Show;
import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
        List<ShowSeatType> findAllByIdEquals(Show show);
}
