import getRandomQuestion from "../services/QuestionService";

import React, { useState, useEffect } from 'react';
import getRandomQuestion from '../services/QuestionService';

function Question({ category }) {
    const [question, setQuestion] = useState(null);
    const [selectedOption, setSelectedOption] = useState(null);
    const [counter, setCounter] = useState(10);

    useEffect(() => {
        setQuestion(getRandomQuestion(category));
    }, []);

    useEffect(() => {
        const timer = setInterval(() => {
            setCounter((prevCounter) => prevCounter - 1);
        }, 1000);

        return () => {
            clearInterval(timer);
        };
    }, []);

    const handleOptionClick = (option) => {
        if (counter > 0) {
            setSelectedOption(option);
        }
    };

    return (
        <div>
            <h3>Pregunta:</h3>
            <p>{question.question}</p>
            {question.options.map((option, index) => (
                <button
                    key={index}
                    onClick={() => handleOptionClick(option)}
                    value={option}
                    disabled={counter === 0}
                >
                    {option}
                </button>
            ))}
            <p>Tiempo restante: {counter}</p>
        </div>
    );
}
