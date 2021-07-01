import React, {useEffect, useState} from "react";
import {Dog} from "../models/Dog";
import {Cat} from "../models/Cat";
import {Adoption} from "../models/Adoption";
import {PetList} from "./PetList";

export const PetTable: React.FC = () => {
  const [dogs, setDogs] = useState<Dog[]>([]);
  const [cats, setCats] = useState<Cat[]>([]);
  const [adoptions, setAdoptions] = useState<Adoption[]>([]);

  useEffect(() => {
    const loadDogs = () => {
      fetch('/api/dogs')
        .then(r => r.json())
        .then(data => {
          let dogs = data.map((item: any) => Dog.fromObject(item))
          setDogs(dogs);
        })
    }
    const loadCats = () => {
      fetch('/api/cats')
        .then(r => r.json())
        .then(data => {
          let cats = data.map((item: any) => Cat.fromObject(item))
          setCats(cats);
        })
    }
    const loadAdoptions = () => {
      fetch('/api/adoption')
        .then(r => r.json())
        .then(data => {
          let adoptions = data.map((item: any) => Adoption.fromObject(item))
          setAdoptions(adoptions);
        })
    }

    loadDogs();
    loadCats();
    loadAdoptions()
  }, []);

  return (
    <>
      <h3>Adopt a pet!</h3>
      <PetList pets={cats} adoptions={adoptions} petType={"CAT"} title={"Cats"} />
      <PetList pets={dogs} adoptions={adoptions} petType={"DOG"} title={"Dogs"} />
  </>)
}