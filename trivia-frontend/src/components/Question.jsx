import React, { useState, useEffect } from "react";
import getRandomQuestion from "../services/QuestionsService";

function Question({ category, setScore }) {
  const [question, setQuestion] = useState(null);
  const [options, setOptions] = useState([]);
  const [selectedOption, setSelectedOption] = useState(null);
  const [counter, setCounter] = useState(10);
  const [selectionMade, setSelectionMade] = useState(false);
  const [counterInterval, setCounterInterval] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const questionData = await getRandomQuestion(category);
        setQuestion(questionData);
  
        // Creamos el array con las opciones
        const optionsArray = [
          questionData.answer,
          questionData.incorrect1,
          questionData.incorrect2,
          questionData.incorrect3,
        ];
  
        // Creamos una función para generar un número aleatorio entre 0 y 1
        const getRandomNumber = () => Math.random() - 0.5;
  
        // Ordenamos el array de forma aleatoria
        setOptions(optionsArray.sort(getRandomNumber));
      } catch (error) {
        console.error("Error al obtener la pregunta:", error);
        // Manejar el error si la promesa no se cumple
      }
    };

    fetchData();
    
    const timer = setInterval(() => {
      setCounter((prevCounter) => {
        // Detener el contador si llega a 0
        if (prevCounter === 0) {
          clearInterval(timer);
          setSelectedOption(null);
        }
        // Decrementar el contador solo si es mayor que 0
        return prevCounter > 0 ? prevCounter - 1 : prevCounter;
      });
    }, 1000);
    setCounterInterval(timer);
  
    return () => {
      clearInterval(timer);
    };
  }, []);

  const handleOptionClick = (option) => {
    if (!selectionMade && counter > 0) {
      setSelectedOption(option);
      setSelectionMade(true); // Establecer que se ha realizado una selección
      clearInterval(counterInterval);
    }
  };

  useEffect(() => {
    if (selectedOption !== null) {
      handleAnswer();
    }
  }, [selectedOption]);

  const handleAnswer = () => {
    if (selectedOption === question.answer) {
      alert("Respuesta correcta!");
      setScore((prevScore) => prevScore + 1);
    } else if(selectedOption !== question.answer){
      alert(`Incorrecto, la respuesta correcta era ${question.answer}`);
    } else {
      alert(`No has seleccionado nada, la respuesta correcta era ${question.answer}` );
    }
  }

  return (
    <div>
      <h3>Pregunta:</h3>
      {question !== null && <p>{question.question}</p>}
      {question !== null &&
        options.map((option, index) => (
          <button
            key={index}
            onClick={() => handleOptionClick(option)}
            value={option}
            disabled={counter === 0 || selectionMade} // Deshabilitar si se ha realizado una selección
          >
            {option}
          </button>
        ))}
      <p>Tiempo restante: {counter}</p>
      {counter === 0 && <p className="timeout">Se acabó el tiempo! {selectedOption}</p>}
    </div>
  );
}

export default Question;