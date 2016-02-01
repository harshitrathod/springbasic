import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by harshit.rathod on 1/2/16.
 */
public class BlogDAOImpl implements BlogDAO
{


    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
   public void setDataSource(DataSource dataSource) {
         this.dataSource = dataSource;

    }


    public void insert(Blog blog) {
            String query="Insert into blog (username,title,content) VALUES(?,?,?)";
        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(query, new Object[] { blog.getUsername(),
                blog.getTitle(), blog.getContent()
        });

    }

    public void delete(int id) {
        String query="DELETE from  blog where blogid=?";

        jdbcTemplate.update(query, new Object[] { id
        });
    }

    public Blog findById(int id) {
        Blog b=null;
        String query="SELECT * from  blog where blogid=?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        b = (Blog) jdbcTemplate.queryForObject(
        query, new Object[] { id }, new BeanPropertyRowMapper(Blog.class));
        return b;
    }
}
