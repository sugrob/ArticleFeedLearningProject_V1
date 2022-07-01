package app.dao;

import app.beans.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


public class ArticleDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Article getById(int id) {
        String sql="select * from article where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Article>(Article.class));
    }

    public int save(Article object) {
        Date date = new Date();
        String sql="insert into article(created_time, title, content) values('"+ Timestamp.from(Instant.now()).toString() +"', '"+object.getTitle()+"', '"+object.getContent()+"')";
        return template.update(sql);
    }

    public int update(Article object) {
        String sql="update article set title='"+object.getTitle()+"', content='"+object.getContent()+"' where id="+object.getId()+"";
        return template.update(sql);
    }

    public int drop(int id) {
        String sql="delete from article where id="+id+"";
        return template.update(sql);
    }

    public List<Article> getList(){
        return template.query("select * from article", new RowMapper<Article>() {
            public Article mapRow(ResultSet rs, int row) throws SQLException {
                Article object = new Article();
                object.setId((long) rs.getInt(1));
                object.setCreatedTime(rs.getTimestamp(2));
                object.setTitle(rs.getString(3));
                object.setContent(rs.getString(4));
                return object;
            }
        });
    }
}