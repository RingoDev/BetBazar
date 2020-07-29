package com.ringodev.server.data.bet;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BetRepository extends MongoRepository<Bet, Long> {
}
