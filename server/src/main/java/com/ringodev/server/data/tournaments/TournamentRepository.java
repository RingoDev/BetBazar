package com.ringodev.server.data.tournaments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TournamentRepository extends JpaRepository<Tournament, Long> {
}

