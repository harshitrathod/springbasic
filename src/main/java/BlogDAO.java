/**
 * Created by harshit.rathod on 1/2/16.
 */
public interface BlogDAO {
    public void insert(Blog blog);
    public void delete(int id);
    public Blog findById(int id);
}
