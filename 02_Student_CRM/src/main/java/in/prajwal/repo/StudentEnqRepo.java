package in.prajwal.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import in.prajwal.entity.StudentEnqEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer>{

}
