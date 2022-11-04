import { Component, OnInit, OnDestroy } from '@angular/core';
import { Polkaman } from 'src/app/models/Polkaman';
import { PolkamanService } from 'src/app/services/polkaman.service';

/**
 * The @Component decorators marks a class as a
 * component. A component has a selector (this is just
 * the HTML tag you use to render the component in the
 * view), a templateUrl (this is just the location of 
 * your TS file for this component), and a styleUrl (
 * this denotes where the style sheet that is associated
 * with this component is).
 * 
 * As an additional note, decorators are a feature of TS.
 * A decorator acts as a wrapper that adds additional 
 * functionality to a class or function.
 * 
 * As our Component is just a TS class, it can have state
 * and a constructor (and of course methods). Notice that
 * it also implements an interface as interfaces are
 * supported in TS as well. Note that OnInit interface is
 * one of several interfaces used in Angular to manage
 * a component's lifecycle. That is to say, Angular
 * instantiates our component classes and also destroys
 * our components for us when they're no longer needed
 * (and, of course, it handles detecting state change in
 * between creation and destruction of components).
 * 
 * NOTE ON DIRECTIVES: Angular components are technically
 * just Angular "directives". An Angular directive is
 * a framework-specific feature that allows you to invoke
 * Angular functionality.
 * 
 * That said, components are NOT the only types of
 * directives in Angular. You also have access to
 * structural and attribute directives. 
 * 
 * We'll focus on structural directives for now within
 * this component.
 */
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit, OnDestroy {

  /**
   * This is the lifecycle hook that is called after a
   * component is instantiated.
   */
  ngOnInit(): void {
    this.retrievePolkamansFromService()
  }

  /**
   * Let's add some state to the component.
   */

  //  ditto:Polkaman = new Polkaman('Ditto', 'This is a generic description', 132, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png')

   /**
    * An array of polkamans. It is currently any because
    * I suspect that I have to fix my DTO.
    */
   polkamans:any;

  /**
   * This is the syntax for creating a constructor in TS.
   * Let's use dependency injection to tell Angular to 
   * inject our PolkamanService for us.
   */
  constructor(private polkamanService:PolkamanService) { }

  /**
   * Let's use our injected service to request all of
   * the Polkamans. We'll make a method that does this.
   */
  retrievePolkamansFromService():void{
    /**
     * Note that the HttpClient methods do NOT return
     * a simple JSOn response body. They instead return
     * a type called an "Observable". Observables, like
     * promises, are used to handle asynchronous tasks
     * and represent eventual values. 
     * 
     * That said, observables are not exactly 
     * like promises. Observables are "lazy" in that
     * you don't get a value until you subscribe to
     * them. Observables represent streams of data. This
     * means that Observables open for use until you
     * unsubscribe from them. As such, we say that we
     * are following a Pub/Sub (Publisher/Subscriber)
     * pattern.
     */
    this.polkamanService.findAllPolkamans().subscribe(
      //The first callback function allows you access the
      //next value in the stream.

      //NOTE: Make a follow-up request for all Polkaman's data
      (data) => {
        this.polkamans = data
        console.log(data)
        console.log(this.polkamans.results)
      },
      () => {
        console.log("didn't get any polkamans...awwww")
      }
    )
  }

  /**
   * This is the method that should be called when a user
   * clicks the "Submit Polkaman" button.
   */

   submitPolkaman(newPolkaman:Polkaman):void{
    this.polkamans.push(newPolkaman);
    console.log(this.polkamans);
   }

  /**
   * This is the hook that is called right before a
   * component is destroyed.
   */
  ngOnDestroy(): void{

  }

}
