/*
TS is statically typed.

- aka this means that once you assign a variable a datatype, it cannot be reassigned afterwards
*/
var count;
//count = "frog";//compile time error due to type mismatch
count = 0;
//full initialization and declaration of a variable would look like this:
var apples = "granny smith";
//there are other new types that we can work with:
//1. enums
//enums allow us to make constants in JS
//this is how you would do enums the old way in js:
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
//WARNING: enums will look funky in js
//here is the newer way to do enums, thanks to ts:
var Colors;
(function (Colors) {
    Colors[Colors["Red"] = 0] = "Red";
    Colors[Colors["Blue"] = 1] = "Blue";
    Colors[Colors["Green"] = 2] = "Green";
})(Colors || (Colors = {}));
; //way cleaner and easier to maintain as a codebase
console.log(Colors.Red);
