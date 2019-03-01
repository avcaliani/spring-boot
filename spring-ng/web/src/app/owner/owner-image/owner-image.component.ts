import { Component } from '@angular/core';

@Component({
  selector: 'app-owner-image',
  template: '<div class="logo"><img src="assets/img/logo.jpg"></div>',
  styles: [
    '.logo img { width: 256px; height: auto; display: block; margin: 5em auto 2em auto; }'
  ]
})
export class OwnerImageComponent { }
