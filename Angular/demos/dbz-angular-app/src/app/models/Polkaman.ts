export class Polkaman{

    /**
     * Unlike in JS, there are access modifiers in TS.
     * By default, these are technically public if we do
     * not specify otherwise. Your options are: public,
     * protected, and private.
     */
    // polkaman_name:string = '';
    // polkaman_description:string = '';
    // polkaman_id:number = 0;
    // polkaman_image:string = '';

    /**
     * Note that if you include an access modifier in
     * front of a parameter name, that parameter is
     * created as a property on the class.
     * @param name 
     * @param polkaman_description 
     * @param id 
     * @param sprites 
     */
    constructor(public name:string, public polkaman_description:string, public id:number, public sprites:any){
        this.name = name;
        this.polkaman_description = polkaman_description;
        this.id = id;
        this.sprites = sprites;
    }
    
}