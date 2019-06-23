package teste.m.bloconotasactivity;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import teste.m.bloconotasactivity.db.NotaRoomDataBase;
import teste.m.bloconotasactivity.db.dao.NotaDAO;
import teste.m.bloconotasactivity.db.entity.NotaEntity;

public class NotaRepository {
    private NotaDAO notaDAO;
    LiveData<List<NotaEntity>> allNotas;
    LiveData<List<NotaEntity>> allFavoritas;


    public NotaRepository(Application application) {
        NotaRoomDataBase db = NotaRoomDataBase.getDatabase(application);
        notaDAO = db.notaDAO();
        allNotas = notaDAO.getALL();
        allFavoritas = notaDAO.getAllFavoritas();
    }

    public LiveData<List<NotaEntity>> getAll() {
        return allNotas;
    }

    public LiveData<List<NotaEntity>> getAllFavoritas() {
        return allFavoritas;
    }

    /*
     **metodo inserte sera executado em segundo plano
     **Devido a isso criamos uma classe que extende do AsyncTask
     **que sera responsavel por inserir os dados
     */
    public void insert(NotaEntity nota) {
        new InserteAsyncTask(notaDAO).execute(nota);
    }

    public void upadte(NotaEntity nota) {
        new UpdateAsyncTask(notaDAO).execute(nota);
    }

    //Classe Assicrona Privata nescessaria para realizar o Insert
    private static class InserteAsyncTask extends AsyncTask<NotaEntity, Void, Void> {
        private NotaDAO notaDAOAsyncTask;

        InserteAsyncTask(NotaDAO notaDAO) {
            notaDAOAsyncTask = notaDAO;
        }

        @Override
        //o metodo abaixo tem como parametro um Array de parametros
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDAOAsyncTask.insert(notaEntities[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<NotaEntity, Void, Void> {
        private NotaDAO notaDAOAsyncTask;

        UpdateAsyncTask(NotaDAO notaDAO) {
            notaDAOAsyncTask = notaDAO;
        }

        @Override
        //o metodo abaixo tem como parametro um Array de parametros
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDAOAsyncTask.update(notaEntities[0]);
            return null;
        }
    }
}

