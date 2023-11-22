import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

//firebase libraries
import { provideFirebaseApp, initializeApp } from '@angular/fire/app'
import { provideFirestore, getFirestore } from "@angular/fire/firestore";//database
import { provideStorage, getStorage } from "@angular/fire/storage";//storage

import { 
  FacebookAuthProvider,
  GoogleAuthProvider,
  EmailAuthProvider,
  getAuth,
  provideAuth
 } from "@angular/fire/auth";

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.log(err));
