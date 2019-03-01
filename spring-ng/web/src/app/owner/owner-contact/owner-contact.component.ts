import { Component, OnInit } from '@angular/core';
import { Contact } from '../owner.model';
import { OwnerService } from '../owner.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-owner-contact',
  templateUrl: './owner-contact.component.html',
  styleUrls: ['./owner-contact.component.scss']
})
export class OwnerContactComponent implements OnInit {

  prod = environment.production;
  online = false;
  contact: Contact;
  constructor(private service: OwnerService) { }

  ngOnInit() {
    this.service.getContact().subscribe(
      (contact: Contact) => {
        this.online = true;
        this.contact = contact;
      },
      (err) => {
        console.error('ERROR: ', err);
        this.contact = {
          name: 'Anthony Caliani',
          tag: '@avcaliani',
          github: 'https://github.com/avcaliani',
          gitlab: 'https://gitlab.com/avcaliani'
        };
      }
    );
  }
}
