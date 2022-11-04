import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Polkaman } from 'src/app/models/Polkaman';

@Component({
  selector: 'app-polkaman-card',
  templateUrl: './polkaman-card.component.html',
  styleUrls: ['./polkaman-card.component.css']
})
export class PolkamanCardComponent implements OnInit {

  /**
   * The PolkamanCardComponent's template currently
   * references a variable named "p". As such, we should
   * create it here. Since the variable should be of type
   * Polkaman, we'll make it that type.
   * 
   * Since our Polkaman is coming from the parent component,
   * we must specify that it is passed down to this component
   * by using the @Input decorator.
   */
  @Input()
  p!:any; //change back when your DTO is fixed

  /**
   * Sometimes, we want a child to be able to pass state
   * to its parent component. In order to achieve this,
   * we want to use event emitters that relay data to a
   * parent component.
   * 
   * We'll actually add the functionality to duplicate
   * a Polkaman in the parent's array by sending the update
   * from the child component. Note that we'll have to add
   * a button to the child component to make this happen.
   */

   @Output()
   polkamanUpdateEvent = new EventEmitter<Polkaman>();

  constructor() { }

  ngOnInit(): void {
  }

  /**
   * This is a method that we will use event binding with.
   */
  duplicatePolkaman(duplicatedPolkaman: Polkaman){
    this.polkamanUpdateEvent.emit(duplicatedPolkaman);
  }
}
