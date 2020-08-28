import { Component, OnInit, Injectable } from '@angular/core';
import { Http } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'recent-tacos',
  templateUrl: 'recents.component.html',
  styleUrls: ['./recents.component.css']
})

@Injectable()
export class RecentTacosComponent implements OnInit {
  recentTacos: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.httpClient.get('http://localhost:8080/design/recent', {
      headers:
        new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*",
          }
        )
    }) // <1>
        .subscribe(data => this.recentTacos = data);

  }
}
