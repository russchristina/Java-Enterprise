import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable} from 'rxjs';
import {map} from 'rxjs/operators'
import { Polkaman } from '../models/Polkaman';

/**
 * Angular services are decorated with the @Injectable decorator.
 * This decorator tells the framework that this class is
 * "injectable", meaning that we can use dependency injection.
 * 
 * Dependency injection occurs when a framework literally
 * injects a dependency for us. That is to say, rather than
 * creating our own instance of the PolkamanService class,
 * Angular will create an instance for us. This means that
 * we will never have to type "new PolkmanService()".
 * 
 * The point of dependency injection is that it removes
 * tight coupling. This makes source code easier to maintain
 * and read.
 */
@Injectable({
  providedIn: 'root'
})
export class PolkamanService {

  /**
   * Recall that we will be using this class to make HTTP
   * requests. We use the HttpClient to do this. We will
   * not make our own instance of the HttpClient because
   * the HttpClient is also @Injectable.
   * 
   * How do we tell Angular to perform dependency injection?
   * We can do in the constructor of the class which needs
   * the dependency.
   */
  
  constructor(private httpClient:HttpClient) { }

  /**
   * Now let's write a method that makes a GET request to
   * the PokeAPI for a list of Polkamans.
   */
  findAllPolkamans():Observable<any>{
    return this.httpClient.get<any>('https://pokeapi.co/api/v2/pokemon?limit=10')
  }

  findSpecificPolkaman(url:string):Observable<Polkaman>{
    return this.httpClient.get<Polkaman>(url);
  }
}
