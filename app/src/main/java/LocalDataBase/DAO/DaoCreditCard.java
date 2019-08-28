package LocalDataBase.DAO;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.securevault19.securevault2019.Record.CreditCard;

import java.util.List;

@Dao
public interface DaoCreditCard {

    @Insert
    void insert(CreditCard creditCard);


    @Update
    void update(CreditCard creditCard);

    @Delete
    void delete(CreditCard creditCard);

    @Query("DELETE FROM creditCard_table")
    void deleteAllRecords();

    @Query("SELECT * FROM creditCard_table ORDER BY priority DESC")
    LiveData<List<CreditCard>> getAllRecords();


}
