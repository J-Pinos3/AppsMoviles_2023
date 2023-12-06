import { Component } from '@angular/core';
import { Geolocation } from '@ionic-native/geolocation/ngx'

import { FormBuilder, FormGroup } from '@angular/forms';
import { from } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  latitude: any = 0
  longitude: any = 0
  url: string = ""
  form: FormGroup;

  constructor(private geolocation: Geolocation, private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      latitud: [''],
      longitud: ['']
    });
    
  }

  options = {
    timeout: 10000,
    enableHighAccuracy: true,
    maximumAge: 3600
  }

  getCurrentCoordinates(){
    this.geolocation.getCurrentPosition().then((resp)=>{
      this.latitude=resp.coords.latitude
      this.longitude=resp.coords.longitude
      this.url=`https://maps.google.com/?ll=${this.latitude},${this.longitude}`

      this.latitude = this.form.get('latitud')?.value
      this.longitude = this.form.get('longitud')?.value
      this.url=`https://maps.google.com/?ll=${this.latitude},${this.longitude}`
      console.log("latitud: " + this.latitude + "\nlongitud: " + this.longitude )
    }
    ).catch( (error) => {console.log('Error, no se puede obtener la ubicación: ', error)} )

    
  }
}
