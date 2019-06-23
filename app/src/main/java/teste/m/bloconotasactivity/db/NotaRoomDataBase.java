package teste.m.bloconotasactivity.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import teste.m.bloconotasactivity.db.dao.NotaDAO;
import teste.m.bloconotasactivity.db.entity.NotaEntity;

//Decorador Room de nossa base de dados
@Database(entities = {NotaEntity.class}, version = 1)
public abstract class NotaRoomDataBase extends RoomDatabase {
    public abstract NotaDAO notaDAO();

    //Variaivel contante da atual intacia, para saber se a mesma esta criada ou não
        private static volatile NotaRoomDataBase INSTANCE;


    public static NotaRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NotaRoomDataBase.class) {
                if (INSTANCE == null) {
                    //Setara a base de dados na variavel, sera criado uma vez
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NotaRoomDataBase.class, "notas_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
