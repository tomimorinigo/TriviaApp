import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

const getRandomQuestion = async (category) => {
  try {
    const response = await axios.get(`${API_URL}/${category}/random`);
    
    // Verificar si la respuesta es exitosa (código de estado 200)
    if (response.status === 200) {
      // Verificar si la respuesta contiene datos
      if (response.data) {
        console.log('Pregunta obtenida:', response.data);
        return response.data;
      } else {
        throw new Error('La respuesta no contiene datos');
      }
    } else {
      throw new Error(`La solicitud falló con el código de estado ${response.status}`);
    }
  } catch (error) {
    // Manejar errores de la solicitud
    console.error('Error al obtener la pregunta:', error.message);
    throw error; // Relanzar el error para que el componente pueda manejarlo si es necesario
  }
}

export default getRandomQuestion;
