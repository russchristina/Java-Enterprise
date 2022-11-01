//Interfaces in TS are an abstract type that tells the the compiler which properties are mapped to which keys.
//aka a way for us to have pre-designed JS objects without too much focus on implementation by introducing OOP to JS

//declaring our interface
interface Person{
    name: string;
    title: string;
    salary: number;
    toDoList: any[];
}

//implement our interface
const user : Person = {
    name: "Bob",
    title: "Software Engineer",
    salary: 60000,
    toDoList: ["sleep", "watch 34 movies", true, 30]
};

console.log(user);