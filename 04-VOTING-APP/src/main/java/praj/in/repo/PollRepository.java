package praj.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import praj.in.entity.Poll;

public interface PollRepository extends JpaRepository<Poll, Long > {

}
