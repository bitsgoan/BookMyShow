package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.bookmyshowscaler.models.Show;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Show findByIdEquals(Long id);

}
