function add(num1, num2){
  if(num2 == undefined){
      return function (num3) {return num1 + num3;};
  }
  else{
    return num1 + num2;
  }
}