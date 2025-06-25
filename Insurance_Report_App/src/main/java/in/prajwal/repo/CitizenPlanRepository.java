package in.prajwal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.prajwal.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	@Query("SELECT DISTINCT c.planName FROM CitizenPlan c WHERE c.planName IS NOT NULL")
	public List<String> getPlanNames();

	@Query("SELECT DISTINCT c.planStatus FROM CitizenPlan c WHERE c.planStatus IS NOT NULL")
	public List<String> getPlanStatus();

	 
	
}
  