export interface UserResponseI{
    idUser:number;
    personModel:PersonI;
    userName:string;
    rolModel:RolI;
}
export interface PersonI{
    name: string;
    lastname: string;
    cardId: number;
    dateBirth: string;
    email: string;    
    profession: string;
    countries: string;
    city: string; 
}
export interface RolI{
    rol: string;    
}