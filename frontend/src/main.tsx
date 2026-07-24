import { createRoot } from 'react-dom/client';
import App from './App.tsx';
import { BrowserRouter } from 'react-router-dom';
import { Header } from './shared/Header';
import "./styles/style.css";

createRoot(document.getElementById('root')!).render(
  <BrowserRouter>
    <Header/>
    <App/>
  </BrowserRouter>
)
