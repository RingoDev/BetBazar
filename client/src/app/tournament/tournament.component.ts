import { Component, OnInit } from '@angular/core';
import { TournamentService } from '../shared';

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css']
})
export class TournamentComponent implements OnInit {
  tournaments: Array<any>;

  constructor(private tournamentService: TournamentService) { }

  ngOnInit() {
    this.tournamentService.getAll().subscribe(
      data => {
        this.tournaments = data;
        console.log(this.tournaments)
      },
      error => console.log(error)
    )
  }
}
