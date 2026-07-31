import { useState } from "react";
import { IoIosArrowDown } from "react-icons/io";
import "../styles/style.css";
import type { CategoryFilterValue } from "../models/CategoryType";

interface Props {
    category: CategoryFilterValue;
    onCategoryChange: (category: CategoryFilterValue) => void;
}

const categories: ReadonlyArray<{ label: string; value: CategoryFilterValue }> = [
    { label: "Todas as categorias", value: "ALL" },
    { label: "Tecnologia", value: "TECHNOLOGY" },
    { label: "Ficção", value: "FICTION" },
    { label: "Ciência", value: "SCIENCE" },
    { label: "Romance", value: "ROMANCE" },
    { label: "História", value: "HISTORY" },
    { label: "Negócios", value: "BUSINESS" },
];

export const CategoryFilter = ({
    category, onCategoryChange
}: Props) => {
    const [filterOpen, setFilterOpen] = useState(false);

    const selectCategory = (category: CategoryFilterValue) => {
        onCategoryChange(category);
        setFilterOpen(false);
    };

    const selectedCategory = categories.find(
        item => item.value === category
    )

    return (
        <div className="category-filter">

            <button
                className="category-trigger"
                type="button"
                onClick={() => setFilterOpen(isOpen => !isOpen)}
                aria-haspopup="listbox"
                aria-expanded={filterOpen}
            >
                <span>
                    {selectedCategory?.label}
                </span>

                <IoIosArrowDown
                    className={
                        filterOpen
                            ? "category-arrow is-open"
                            : "category-arrow"
                    }
                    aria-hidden="true"
                />
            </button>

            {filterOpen && (
                <ul
                    className="category-menu"
                    role="listbox"
                    aria-label="Categorias de livros"
                >

                    {categories.map(item => (
                        <li
                            key={item.value}
                            role="option"
                            aria-selected={item.value === category}
                        >
                            <button
                                type="button"
                                onClick={() =>
                                    selectCategory(item.value)
                                }
                            >
                                {item.label}
                            </button>
                        </li>
                    ))}

                </ul>
            )}

        </div>
    );
};
