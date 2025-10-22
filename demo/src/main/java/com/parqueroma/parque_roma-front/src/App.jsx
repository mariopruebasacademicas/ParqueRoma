import './App.css';

import logoParqueRoma from './assets/PR-R-blanca'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logoParqueRoma} className="App-logo" alt="CDE Parque Roma Logo" />
        <p>
          CDE Parque Roma - DataBase
        </p>
        <a
          className="App-link"
          href="https://www.cdeparqueroma.es"
          target="_blank"
          rel="noopener noreferrer"
        >
          www.cdeparqueroma.es
        </a>
      </header>
    </div>
  );
}

export default App;
