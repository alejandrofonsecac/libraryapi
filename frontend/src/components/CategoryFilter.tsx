import { useState } from "react";
import { IoIosArrowDown } from "react-icons/io";
import "../styles/style.css";

export const CategoryFilter = () => {
    const [filterOpen, setFilterOpen] = useState(false);
    const [categorySelect, setCategorySelect] = useState("Todas as Categorias");
    const categories = ["Todas as Categorias", "Ficção Científica", "Romance", "Terror", "História", "Fantasia"];

    const selectCategory = (category: string) => {
        setCategorySelect(category);
        setFilterOpen(false);
    };

    return (
        <div className="category-filter">
            <button 
            className="category-trigger" 
            type="button" 
            onClick={() => 
                setFilterOpen((isOpen) => !isOpen)} 
                aria-haspopup="listbox" 
                aria-expanded={filterOpen}>
            <span>{categorySelect}</span>
                <IoIosArrowDown className={filterOpen ? "category-arrow is-open" : "category-arrow"} aria-hidden="true" />
            </button>

            {filterOpen && (
                <ul className="category-menu" role="listbox" aria-label="Categorias de livros">
                    {categories.map((category) => (
                        <li key={category} role="option" aria-selected={category === categorySelect}>
                            <button type="button" onClick={() => selectCategory(category)}>{category}</button>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};
