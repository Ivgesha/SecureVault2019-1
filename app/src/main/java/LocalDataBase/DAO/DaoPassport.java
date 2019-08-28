package LocalDataBase.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.securevault19.securevault2019.Record.CreditCard;
import com.securevault19.securevault2019.Record.OnlineShoppingApp;
import com.securevault19.securevault2019.Record.Passport;

import java.util.List;

public interface DaoPassport {

    @Insert
    void insert(Passport passport);


    @Update
    void update(Passport passport);

    @Delete
    void delete(Passport passport);

    @Query("DELETE FROM  password_table")
    void deleteAllPassportRecords();

    @Query("SELECT * FROM password_table ORDER BY priority DESC")
    LiveData<List<Passport>> getAllPassportRecords();

}
