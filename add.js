let add = function () {
    return arguments.length === 1 ? (num) => (arguments[0] + num) : arguments[0] + arguments[1];
}