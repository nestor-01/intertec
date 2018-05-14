package com.intertec.model.repository;

import com.intertec.model.data.RestrictedWord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface RestrictedWordRepository extends JpaRepository<RestrictedWord, Integer> {
}
