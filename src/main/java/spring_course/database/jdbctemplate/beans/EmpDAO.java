package spring_course.database.jdbctemplate.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

    public void resetEmp(){
        template.execute("delete from Emp");
    }

}
