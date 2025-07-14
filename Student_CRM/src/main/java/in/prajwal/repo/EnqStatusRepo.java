package in.prajwal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.prajwal.entity.EnqStatusEntity;

public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity, Integer> {
}
