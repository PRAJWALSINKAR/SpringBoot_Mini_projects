package in.prajwal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.prajwal.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {
}
