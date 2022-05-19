package daos;

import entities.ContactInfo;
import java.sql.SQLException;
import java.util.List;

public interface ContactInfoDao {

    public int createInfo(ContactInfo info) throws SQLException;

    public ContactInfo readInfo(int id) throws SQLException;

    public List<ContactInfo> readAllInfo() throws SQLException;

    public boolean updateInfo(ContactInfo info) throws SQLException;

    public boolean deleteInfo(int id) throws SQLException;
}
