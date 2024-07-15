package com.blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blog.model.*;

import com.blog.repository.DbRepository;

@CrossOrigin(origins = "http://localhost:8087")
@RestController
@RequestMapping("/api")
public class DbController {
	
	@Autowired
	DbRepository dbRepo;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<DbModel>> getAllTutorials(@RequestParam(required = false) String title) {
			try {
				List<DbModel> tutorials = new ArrayList<DbModel>();

				if (title == null)
					dbRepo.findAll().forEach(tutorials::add);
				else
					dbRepo.findByTitleContaining(title).forEach(tutorials::add);

				if (tutorials.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(tutorials, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
//	@GetMapping("/tutorials/{id}")
//	public ResponseEntity<DbModel> getTutorialById(@PathVariable("id") long id) {
//		0<DbModel> tutorialData = dbRepo.findById(id);
//
//		if (tutorialData.isPresent()) {
//			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
//	@PostMapping("/tutorials")
//	public ResponseEntity<DbModel> createTutorial(@RequestBody DbModel tutorial) {
//		try {
//			DbModel _tutorial = dbRepo.save(new DbModel(tutorial.getTitle(), tutorial.getDesc(), false));
//			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@PutMapping("/tutorials/{id}")
//	public ResponseEntity<DbModel> updateTutorial(@PathVariable("id") long id, @RequestBody DbModel tutorial) {
//		Optional<DbModel> tutorialData = dbRepo.findById(id);
//
//		if (tutorialData.isPresent()) {
//			DbModel _tutorial = tutorialData.get();
//			_tutorial.setTitle(tutorial.getTitle());
//			_tutorial.setDesc(tutorial.getDesc());
//			_tutorial.setPublisher(tutorial.isPublished());
//			return new ResponseEntity<>(dbRepo.save(_tutorial), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			dbRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			dbRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<DbModel>> findByPublished() {
		try {
			List<DbModel> tutorials = dbRepo.findByPublished(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
