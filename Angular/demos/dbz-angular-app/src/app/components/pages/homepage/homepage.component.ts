import { Component, OnInit, OnDestroy } from '@angular/core';
import { Polkaman } from 'src/app/models/Polkaman';

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
   * Let's add some state to the component.
   */

  //  ditto:Polkaman = new Polkaman('Ditto', 'This is a generic description', 132, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png')

   /**
    * An array of polkamans
    */
   polkamans:Polkaman[] = [new Polkaman('Ditto', 'This is a generic description', 132, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png'),
  new Polkaman('Electricity Mouse', 'electric rodent', 2, '', ''), new Polkaman('Mime Polkaman', 'a mime but in Polkamans instead', 30, '', ''), new Polkaman('literally a rock', 'but which one', 20, '', '')];

  /**
   * This is the syntax for creating a constructor in TS.
   */
  constructor() { }

  /**
   * This is the method that should be called when a user
   * clicks the "Submit Polkaman" button.
   */

   submitPolkaman():void{
    console.log("the button was clicked")
   }

  /**
   * This is the lifecycle hook that is called after a
   * component is instantiated.
   */
  ngOnInit(): void {
  }

  /**
   * This is the hook that is called right before a
   * component is destroyed.
   */
  ngOnDestroy(): void{

  }

}
