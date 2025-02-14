package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.bookmyshowscaler.models.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Show findByIdEquals(Long id);

}
