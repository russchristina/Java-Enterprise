/*
TS is statically typed. 

- aka this means that once you assign a variable a datatype, it cannot be reassigned afterwards
*/

var count: number;
//count = "frog";//compile time error due to type mismatch
count = 0;

//full initialization and declaration of a variable would look like this:
var apples: string = "granny smith";

//there are other new types that we can work with:
//1. enums
//enums allow us to make constants in JS

//this is how you would do enums the old way in js:
const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

//WARNING: enums will look funky in js

//here is the newer way to do enums, thanks to ts:
enum Colors {'Red', 'Blue', 'Green'}; //way cleaner and easier to maintain as a codebase
console.log(Colors.Red);