import { useEffect, useState } from "react";
import bookService from "../service/bookService";

export const Category = () => {

    const books = () => {
        const [books, setBooks] = useState([]);

        useEffect(() => {
            bookService
            .getBooks(response => {
                setBooks(response.data);
            })
        }, []);
    }
    
    return(
        <>
            Aqui seria renderizado as categorias conforme o filtro
        </>
    )
}