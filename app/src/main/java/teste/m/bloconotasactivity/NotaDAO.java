package teste.m.bloconotasactivity;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NotaDAO {
    @Insert
    void insert(NotaEntity nota);
    @Update
    void update(NotaEntity nota);

    @Query("DELETE FROM notas")
    void deleteAll();

    @Query("DELETE FROM notas WHERE id =:idNota")
    void deleteById(int idNota);

    @Query("SELECT * FROM notas ORDER BY titulo ASC")
    LiveData<List<NotaEntity>> getALL();

    @Query("SELECT * FROM notas WHERE favorita LIKE 'true'")
    LiveData<List<NotaEntity>> getAllFavoritas();
}
