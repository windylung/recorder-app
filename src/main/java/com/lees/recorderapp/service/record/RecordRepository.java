package com.lees.recorderapp.service.record;

import com.lees.recorderapp.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    public Optional<Record> findByUserIdAndKeyDate(Integer userId, String keyDate);
}
