import {Adoption} from "../models/Adoption";
import React from "react";
import {Pet} from "../models/Pet";
import { Link } from "react-router-dom";

interface petListProps {
  pets: Pet[];
  adoptions: Adoption[];
  petType: String;
  title: String;
}

export const PetList: React.FC<petListProps> = (props) => {
  const {pets, adoptions, petType, title} = props;

  const getAdoption = (petId: number) => {
    return adoptions.find(a => a.petId === petId && a.petType === petType);
  }

  return (
    <div className='List-table'>
      <h4>{title}</h4>
      <table>
        <thead>
        <tr>
          <td>Name</td>
          <td>Age</td>
          <td>Type</td>
          <td>Gender</td>
          <td>Picture</td>
          <td />
        </tr>
        </thead>
        <tbody>
        {pets.map(pet => {
          return <tr key={pet.id}>
            <td>{pet.name}</td>
            <td>{pet.age}</td>
            <td>{pet.type}</td>
            <td>{pet.gender}</td>
            <td><img src={pet.imageUrl} alt={pet.name} className='Image-size' /></td>
            <td>
              { getAdoption(pet.id) ?
                 <span>Adopted by {getAdoption(pet.id)?.ownerName}</span> :
                <Link to={`/adopt/${pet.petType}/${pet.id}`}>Adopt</Link>
              }
            </td>
          </tr>
        })}
        </tbody>
      </table>
    </div>
  );
}