import {Pet} from "./Pet";

export class Cat implements Pet {
  id: number;
  name: string;
  age: number;
  type: string;
  imageUrl: string;
  gender: string;
  petType: string;

  constructor(id: number, name: string, age: number, type: string, imageUrl: string, gender: string) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.type = type;
    this.imageUrl = imageUrl;
    this.gender = gender;
    this.petType = 'CAT';
  }

  static fromObject = (object: any) => {
    return new Cat(object.id, object.name, object.age, object.type, object.imageUrl, object.gender);
  }
}