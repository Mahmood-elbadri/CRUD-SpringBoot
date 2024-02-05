package com.spring.testing.service.imp;

import com.spring.testing.exception.SourceNotFound;
import com.spring.testing.model.Friend;
import com.spring.testing.repository.FriendRepository;
import com.spring.testing.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImp implements FriendService {

    FriendRepository friendRepository;

    @Autowired
    public FriendServiceImp(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public Friend createFriend(Friend friend) {
        friendRepository.save(friend);
        return friend;
    }

    @Override
    public Friend getFriend(int id) {
        Friend friend = friendRepository.findById(id).orElseThrow(() ->
                new SourceNotFound("Friend not found","id",id));
        return friend;
    }

    @Override
    public List<Friend> getFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friend updateFriend(int id,Friend friend) {
        Friend friend1 = friendRepository.findById(id).orElseThrow(() -> new SourceNotFound("Friend","id",id));
        friend1.setName(friend.getName());
        friend1.setNumber(friend.getNumber());
        friend1.setNationality(friend.getNationality());
        friendRepository.save(friend1);
        return friend1;
    }

    @Override
    public void deleteFriend(int id) {
        friendRepository.findById(id).orElseThrow(
                () -> new SourceNotFound("Friend","id",id));
        friendRepository.deleteById(id);
    }
}
