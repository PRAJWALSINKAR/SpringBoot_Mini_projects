package praj.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import praj.in.entity.Poll;
import praj.in.service.PollService;

@RestController
@RequestMapping("/api/polls")

public class PollController {
	
   private PollService pollService;
   
     public PollController(PollService pollService) {
	this.pollService = pollService;
} 

	@PostMapping
	public Poll createPoll(@RequestBody Poll poll) {
		return pollService.createPoll(poll);
	}
	@GetMapping
	public List<Poll> getAllPolles(){
		return pollService.getAllpolls();
	}
	
		@GetMapping
		public ResponseEntity<Poll> getPoll(){
			return pollService.getAllPolls();
	}
}

