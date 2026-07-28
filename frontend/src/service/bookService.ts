import api from "../api/axios";

const getBooks = () => {
    return api.get("/books")
}

export default{
    getBooks
}