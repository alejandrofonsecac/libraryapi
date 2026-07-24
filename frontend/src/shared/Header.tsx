import { IoLibrary } from "react-icons/io5";
import { CiSearch } from "react-icons/ci";
import "../styles/Header/Header.css";
import { CategoryFilter } from "../components/CategoryFilter";

export const Header = () => {
    return (
        <header className="site-header">
            <nav className="header-content" aria-label="Navegação principal">
                <a className="brand" href="/" aria-label="Bibliotech - página inicial">
                    <span className="brand-icon" aria-hidden="true"><IoLibrary /></span>
                    <span>Bibliotech</span>
                </a>

                <div className="header-actions">
                    <label className="search-field" htmlFor="book-search">
                        <CiSearch aria-hidden="true" />
                        <input id="book-search" type="search" placeholder="Buscar livros, autores..." aria-label="Buscar livros ou autores" />
                    </label>
                    <CategoryFilter />
                </div>
            </nav>
        </header>
    );
};
