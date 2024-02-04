const API_URL = 'http://localhost:8080/api';

const getRandomQuestion = async (category) => {
  const response = await axios.get(`${API_URL}/${category}/random`);
  return response.data;
}

export default getRandomQuestion;