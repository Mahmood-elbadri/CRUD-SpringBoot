package com.spring.testing.service;

import com.spring.testing.model.Friend;

import java.util.List;

public interface FriendService {
    Friend createFriend(Friend friend);

    Friend getFriend(int id);

    List<Friend> getFriends();

    Friend updateFriend(int id, Friend friend);

    void deleteFriend(int id);
}
