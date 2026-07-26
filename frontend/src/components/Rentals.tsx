import { CiClock1, CiWarning  } from "react-icons/ci";
import { TbCalendarClock } from "react-icons/tb";

export const Rentals = () =>{

    return(
        <>
            <main>
                <div>
                    <h1>Meus Alugueis</h1>
                    <p>Acompanhe suas devoluções e multas</p>
                </div>

                <div>
                    <div>
                        <div>
                            <CiClock1 /> <p>Ativos</p>
                        </div>
                    </div>

                    <div>
                        <div>
                            <CiWarning/> <p>Atrasados</p>
                        </div>
                    </div>

                    <div>
                        <div>
                            <TbCalendarClock/> <p>Multa total</p>
                        </div>
                    </div>
                </div>

                <div className="books-rentals">
                    <span>Aqui aparecera os livros</span>
                </div>
            </main>
        </>
    )
}