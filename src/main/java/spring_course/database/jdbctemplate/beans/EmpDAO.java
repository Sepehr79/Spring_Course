package spring_course.database.jdbctemplate.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("empDao")
public class EmpDAO {

    private final JdbcTemplate template;

    @Autowired
    public EmpDAO(JdbcTemplate template){
        this.template = template;
    }

    public void saveEmp(Emp emp){
        template.update("insert into Emp (name, lastName, age, gender, id) values(?, ?, ?, ?, ?)",
                emp.getName(), emp.getLastName(), emp.getAge(), emp.getGender().name(), emp.getId());
    }

    public void updateEmp(Emp emp){
        template.update("update Emp set name = ?, lastName = ?, age = ?, gender = ? where id = ?",
                emp.getName(), emp.getLastName(), emp.getAge(), emp.getGender().name(), emp.getId());
    }

    public Emp getEmp(int id){
        return template.execute("select * from Emp where id = ?",
                (PreparedStatementCallback<Emp>) preparedStatement -> {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                Gender gender = (resultSet.getString("gender").equals("MALE"))?Gender.MALE:Gender.FEMALE;

                return new Emp(name, lastName, age, gender, id);
            }
            return null;
        });
    }

    public List<Emp> getEmps(){
        return template.execute("select * from Emp", (PreparedStatementCallback<List<Emp>>) preparedStatement ->
        {
            List<Emp> empList = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Emp emp = new Emp(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender").equals("MALE")?Gender.MALE:Gender.FEMALE,
                        resultSet.getInt("id"));

                empList.add(emp);
            }
            return empList;
        });
    }

    public void deleteEmp(Emp emp){
        template.update("delete from Emp where id = ?", emp.getId());
    }

    public void resetEmp(){
        template.execute("delete from Emp");
    }

}
