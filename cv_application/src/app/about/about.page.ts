import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.page.html',
  styleUrls: ['./about.page.scss'],
})
export class AboutPage implements OnInit {

  public hobbies = [
    {
      id: '1',
      title: 'Going To Concerts',
      imageUrl: 'https://i.ytimg.com/vi/9kWtv72YQf4/maxresdefault.jpg'
    },
    {
      id: '2',
      title: 'Watching Movies',
      imageUrl: 'https://s3.amazonaws.com/sfc-datebook-wordpress/wp-content/uploads/sites/2/2020/06/MER98ca337e4401fb520b7b3dde024e5_lasalle0614-1024x683.jpg'
    },
    {
      id: '3',
      title: 'Cooking',
      imageUrl: 'https://play-lh.googleusercontent.com/JRG8zhT2vAD9Fi_VFvhjFbXsJiVNrwKoXHtIwqq5xKHkXTwl6_gjfXnwbql-xOZ5iiKM=w240-h480-rw'
    },
    {
      id: '4',
      title: 'Reading',
      imageUrl: 'https://ej2uh7skei8.exactdn.com/wp-content/uploads/2023/07/SoR_Microsite-Update_June2023_Image1_V3.png'
    },
    {
      id: '5',
      title: 'Playing Basketball',
      imageUrl: 'https://mediaproxy.salon.com/width/1200/https://media.salon.com/2017/03/pickup-basketball.jpg'
    },
  ] 

  constructor() { }

  ngOnInit() {
  }

}
