export interface PostI{
    idUser:number;
    bodyPost:string;
    category:string;
}

export interface PostResponseI{
    idPost:number;
    idUser:number;
    bodyPost:string;
    category:string;
    datePost:string;
}
