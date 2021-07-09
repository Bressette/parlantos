import { Component, OnInit } from '@angular/core';
import {OktaAuthService} from '@okta/okta-angular';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage implements OnInit {

  friendsSelected = true;

  chatSelected: number;

  constructor(private oktaAuth: OktaAuthService) { }

  ngOnInit() {
    console.log(`Access token: ${this.oktaAuth.getAccessToken()}`);
  }

  onFriendsClicked() {
    if (!this.friendsSelected) {
      this.friendsSelected = !this.friendsSelected;
      this.chatSelected = -1;
    }
  }

  onChatSelected(index: number) {
    this.chatSelected = index;
    this.friendsSelected = false;
  }

}
