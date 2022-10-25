function add(x,y){
	
    if(y == null){
		
        function add(y){
            console.log(x+y)
        }
		
        return add;
    }
	
    else{
        console.log(x+y)
    }
}