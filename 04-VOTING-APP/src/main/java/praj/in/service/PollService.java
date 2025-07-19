package praj.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import praj.in.entity.Poll;
import praj.in.repo.PollRepository;

@Service
public class PollService {
		
		private final PollRepository pollRepository;
		
		public PollService(PollRepository pollRepository) {
			this.pollRepository = pollRepository;
		}
		public Poll createPoll(Poll poll) {
		return pollRepository.save(poll);
	}
		public List<Poll> getAllpolls() {
			
			return pollRepository.findAll();
		}

}
