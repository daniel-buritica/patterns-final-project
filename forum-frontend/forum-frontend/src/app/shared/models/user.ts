export interface User {
  uid: string;

  email: string;

  displayName: string;

  photoURL: string;

  emailVerified: boolean;
}

export interface PersonResponseI{
    id: number;
    name: string;
    lastname: string;
    cardId: number;
    dateBirth: string;
    profession: string;
    email: string;
    countries: string;
    city: string;
}