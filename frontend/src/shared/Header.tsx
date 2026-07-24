import { IoLibrary } from "react-icons/io5";
import "../styles/Header/Header.css";

export const  Header = () => {
    return(
        <>
            <nav>
                <div className="container">
                    <span className="">
                        <IoLibrary className="icons"/>
                    </span>
                    <h1>Bibliotech</h1>
                </div>


                <div>
                    Busca
                </div>

                <button>
                    Filtrar
                </button>

                <span></span>
            </nav>
        </>
    )
}