export class Adoption {
  petId: number;
  petType: string;
  ownerName: string;


  constructor(petId: number, petType: string, ownerName: string) {
    this.petId = petId;
    this.petType = petType;
    this.ownerName = ownerName;
  }

  static fromObject = (object: any) => {
    return new Adoption(object.petId, object.petType, object.ownerName);
  }
}