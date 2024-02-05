package com.spring.testing.controller;

import com.spring.testing.model.Friend;
import com.spring.testing.service.FriendService;
import com.spring.testing.service.imp.FriendServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FriendController {

    FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friends")
    public ResponseEntity<Friend> createFriend(@RequestBody Friend friend){
        friendService.createFriend(friend);
        return new ResponseEntity<>(friend, HttpStatus.CREATED);
    }

    @GetMapping("/friends/{id}")
    public ResponseEntity<Friend> getFriend(@PathVariable int id){
        return new ResponseEntity<>(friendService.getFriend(id),HttpStatus.OK);
    }

    @GetMapping("/friends")
    public ResponseEntity<List<Friend>> getEmployees(){
        return new ResponseEntity<>(friendService.getFriends(),HttpStatus.OK);
    }
    @PutMapping("/friends/{id}")
    public ResponseEntity<Friend> updateFriend(@PathVariable int id,@RequestBody Friend friend){
        return new ResponseEntity<>(friendService.updateFriend(id, friend),HttpStatus.OK);
    }
    @DeleteMapping("/friends/{id}")
    public ResponseEntity<String> deleteFriend(@PathVariable int id){
        friendService.deleteFriend(id);
        return new ResponseEntity<>("Friend removed",HttpStatus.OK);

    }
}
