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
     * @param polkaman_name 
     * @param polkaman_description 
     * @param polkaman_id 
     * @param polkaman_image 
     */
    constructor(public polkaman_name:string, public polkaman_description:string, public polkaman_id:number, public polkaman_image:string,
        public polkaman_regular_image:string){
        this.polkaman_name = polkaman_name;
        this.polkaman_description = polkaman_description;
        this.polkaman_id = polkaman_id;
        this.polkaman_image = polkaman_image;
    }
    
}