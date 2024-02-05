import "./App.css";
import { useState } from "react";
import Question from "./components/Question";

function App() {
  const [username, setUsername] = useState("");
  const [started, setStarted] = useState(false);
  const [category, setCategory] = useState("");
  const [categorySelected, setCategorySelected] = useState(false);
  const [nextQuestion, setNextQuestion] = useState(false);
  const [score, setScore] = useState(0);

  const handleCategoryChange = (e) => {
    setCategory(e.target.value);
    console.log(category);
  };

  const handleNextQuestion = () => {
    setNextQuestion(!nextQuestion);
  };

  const handleFinish = () => {
    setCategorySelected(false);
    setNextQuestion(false);
    setCategory("");
    setScore(0);
  }

  return (
    <>
      {!started && (
        <section>
          <h1>Bienvenido a mi Trivia!</h1>
          <p>Ingresa tu nombre para comenzar:</p>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <button onClick={() => setStarted(true)}>Comenzar</button>
        </section>
      )}

      {started && !categorySelected && (
        <section>
          <h2>Comenzamos, {username}!</h2>
          <p>Elige una categoría:</p>
          <select value={category} onChange={handleCategoryChange}>
            <option value="history">Historia</option>
            <option value="entertainment">Entretenimiento</option>
            <option value="sports">Deportes</option>
          </select>
          <button onClick={() => setCategorySelected(true)}>Comenzar</button>
        </section>
      )}

      {categorySelected && !nextQuestion && (
        <section>
          <h2>Categoria seleccionada: {category}</h2>
          <Question category={category} setScore={setScore} />
          <button onClick={handleNextQuestion}>Siguiente Pregunta</button>
          <p>Puntaje: {score}</p>
          <button onClick={handleFinish}>Terminar</button>
        </section>
      )}

      {nextQuestion && (
        <section>
          <h2>Categoria seleccionada: {category}</h2>
          <Question category={category} setScore={setScore}/>
          <button onClick={handleNextQuestion}>Siguiente Pregunta</button>
          <p>Puntaje: {score}</p>
          <button onClick={handleFinish}>Terminar</button>
        </section>
      )}
    </>
  );
}

export default App;
