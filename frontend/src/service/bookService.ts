import api from "../api/axios";
import type { Book } from "../models/Book";

export const bookService = {
    getBooks: () => {
        return api.get<Book[]>("/books");
    }
}