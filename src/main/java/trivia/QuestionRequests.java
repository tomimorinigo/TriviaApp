package trivia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionRequests {

    public static Question request(int category, int questionId) {
        Connection con = null;
        Statement stmt = null;
        Question questionObject = null;

        try{
            con = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
            stmt = con.createStatement();
            String sql = "SELECT * FROM - WHERE id = ?";

            String categoryString = "";
            if (category == 1) {
                sql = sql.replace("-", "deportes");
                categoryString = "deportes";
            } else if (category == 2){
                sql = sql.replace("-", "historia");
                categoryString = "historia";
            } else if (category == 3) {
                sql = sql.replace("-", "entretenimiento");
                categoryString = "entretenimiento";
            }

            sql = sql.replace("?", String.valueOf(questionId));

            ResultSet result = stmt.executeQuery(sql);

            while(result.next()) {
                String question = result.getString("pregunta");
                String answer = result.getString("respuesta");
                
                List<String> options = new ArrayList<String>();
                options.add(result.getString("respuesta"));
                options.add(result.getString("incorrecta1"));
                options.add(result.getString("incorrecta2"));
                options.add(result.getString("incorrecta3"));

                questionObject = new Question(question, answer, categoryString, options);
            }
            
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return questionObject;
    }
}
