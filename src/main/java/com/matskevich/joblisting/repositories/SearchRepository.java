package com.matskevich.joblisting.repositories;

import com.matskevich.joblisting.models.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
