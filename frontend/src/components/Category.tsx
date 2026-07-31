import { useEffect, useState } from "react";
import { bookService } from "../service/bookService";
import type { Book } from "../models/Book";
import { CategoryFilter } from "./CategoryFilter";
import type { CategoryFilterValue } from "../models/CategoryType";


export const Category = () => {

    const [books, setBooks] = useState<Book[]>([]);
    const [category, setCategory] = useState<CategoryFilterValue>("ALL");
    const [error, setError] = useState<string | null>(null);

    const filteredBooks = category === "ALL"
        ? books
        : books.filter((book) => book.category === category);

    useEffect(() => {
        const getBooks = async () => {
            try {
                const response = await bookService.getBooks();
                setBooks(response.data);
            } catch {
                setError("Não foi possível carregar os livros.");
            }
        };

        void getBooks();
    }, []);
    
    return(
        <> 
            <section aria-label="Livros por categoria">
                <CategoryFilter
                    category={category}
                    onCategoryChange={setCategory}
                />

                {error && <p role="alert">{error}</p>}

                {!error && filteredBooks.length === 0 && (
                    <p>Nenhum livro encontrado nesta categoria.</p>
                )}

                <div>
                    {filteredBooks.map((book) => (
                        <article key={book.id}>
                            <h2>{book.title}</h2>
                            <p>{book.author}</p>
                            <p>R$ {book.price}</p>
                            <p>Estoque: {book.stock}</p>
                        </article>
                    ))}
                </div>
            </section>
        </>
    )
}
