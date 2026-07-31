import type { CategoryType } from "./CategoryType";

export interface Book {
    id: number;
    title: string;
    author: string;
    price: number;
    stock: number;
    category: CategoryType;
}