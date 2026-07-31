import { useEffect, useState } from "react";
import { bookService } from "../service/bookService";
import type { Book } from "../models/Book";

export const Category = () => {

    const [books, setBooks] = useState<Book[]>([]);

    useEffect(() => {
        const fetchBooks = async () =>{
            const response = await bookService.getBooks();
            setBooks(response.data);
        }
        fetchBooks();   
    }, []);
    
    return(
        <> 
            <div>
                {books.map(book => (
                    <div key={book.id}>
                        <h2>{book.title}</h2>
                        <p>{book.author}</p>
                        <p>R$ {book.price}</p>
                        <p>Estoque: {book.stock}</p>
                    </div>
                ))}
            </div>
        </>
    )
}