import React, {useEffect, useState} from "react";
import {Cat} from "../models/Cat";
import {Pet} from "../models/Pet";
import {Dog} from "../models/Dog";
import { Link } from "react-router-dom";

export interface AdoptionFormProps {
  type: string;
  id: number;
}

export interface AdoptionFormParams {
  type: string;
  id: string;
}

export const AdoptionForm: React.FC<AdoptionFormProps> = (props) => {
  const {type, id} = props;

  const [adoptionSuccess, setAdoptionSuccess] = useState<boolean>(false);
  const [pet, setPet] = useState<Pet>()
  const [adopterName, setAdoptorName] = useState<string>('');

  useEffect(() => {
    let cancelled = false;
    const loadPet = () => {
      if (type === "CAT") {
        fetch(`/api/cats/${id}`)
          .then(r => r.json())
          .then(data => {
            !cancelled && setPet(Cat.fromObject(data))
          })
      } else {
        fetch(`/api/dogs/${id}`)
          .then(r => r.json())
          .then(data => {
            !cancelled && setPet(Dog.fromObject(data))
          })
      }
    };

    loadPet();

    return () => {
      cancelled = true;
    }
  }, [type, id])

  const handleChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
    setAdoptorName(event.target.value);
  }

  const handleSubmit = async (event: { preventDefault: () => void; }) => {
    event.preventDefault();
    const requestData = {
      "petId": pet?.id,
      "petType": pet?.petType,
      "ownerName": adopterName
    }
    await fetch('/api/adoption', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestData)
    });
    setAdoptionSuccess(true);
  };

  const renderForm = () => {
    return pet && <>
			<p>To adopt {pet.name}, fill out your name below</p>
			<form onSubmit={handleSubmit}>
				<label>
					Adopter Name:
					<input type="text" value={adopterName} onChange={handleChange} />
				</label>
				<input type="submit" value="Submit" />
			</form>
		</>
  };

  const renderSuccess = () => {
    return <>
      <p>Congrats {adopterName}, you adopted {pet?.name}!</p>
      <Link to='/'>Return to the adoption listing</Link>
    </>
  };

  return (
    pet ?
      <div>
        <h4>Adopt a pet</h4>
        <div style={{alignContent: "center"}}>
          <img src={pet.imageUrl} alt={pet.name} className='Image-size' />
          {adoptionSuccess ? renderSuccess() : renderForm()}
        </div>
      </div>
      : <></>
  );
}