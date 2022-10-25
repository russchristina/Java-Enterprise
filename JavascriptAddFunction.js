function add(num1,num2) {
	if(num2) return num1+num2;
  return function(num3) {
    return num1 + num3;
  }
}