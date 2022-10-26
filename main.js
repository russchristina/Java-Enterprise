function add(a,b){
    if (b === undefined) {
      function newInput(c){
        return a + c;
      }
    } else return a + b;
  }