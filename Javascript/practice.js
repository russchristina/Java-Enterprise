function add(a, b) {
	if (!b) {
		return function (b) {
			return a + b;
		};
	} else {
		let c = a + b;
		return c;
	}
}

console.log(add(2, 6));
console.log(add(10)(5));
