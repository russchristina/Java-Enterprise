import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Polkaman } from 'src/app/models/Polkaman';
import { PolkamanService } from 'src/app/services/polkaman.service';

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
   * 
   * Note that what I am accepting from the parent is not
   * a full Polkaman; it's only the polkaman's name and
   * a URL that I will need to use to grab the full Polkaman
   * info.
   */
  @Input()
  p!:any; //NOT A REAL POLKAMAN

  realPolkaman:Polkaman = new Polkaman('', '', 0, {});

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

  constructor(private polkamanService:PolkamanService) { }

  ngOnInit(): void {
    this.findSpecificPolkaman()
  }

  /**
   * This is a method that we will use event binding with.
   */
  duplicatePolkaman(duplicatedPolkaman: Polkaman){
    this.polkamanUpdateEvent.emit(duplicatedPolkaman);
  }

  findSpecificPolkaman(){
    this.polkamanService.findSpecificPolkaman(this.p.url).subscribe(
      (data) => {
        console.log(data)
        this.realPolkaman = data
    }),
    () => {
      console.log('retrieval of individual polkaman failed')
    }
  }
}
