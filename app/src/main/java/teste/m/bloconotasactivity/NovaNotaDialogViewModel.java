package teste.m.bloconotasactivity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.view.LayoutInflater;

import java.util.List;

import teste.m.bloconotasactivity.db.entity.NotaEntity;

public class NovaNotaDialogViewModel extends AndroidViewModel {
    // TODO: Implement the
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notasRepository;

    public NovaNotaDialogViewModel(Application application){
        super(application);
        notasRepository = new NotaRepository(application);
        allNotas = notasRepository.getAll();
    }

    //O Fragmento que precisa receber a nova lista de dados consultara desse metodo
    //Metodo de Consulta
    public LiveData<List<NotaEntity>> getAllNotas(){
        return allNotas;
    }
    //O Fragmento que insere uma nova nota, deve se comunicar com este metodo
    //Metodo de Insercao
    public void inserteNota(NotaEntity novaNotaEntity){notasRepository.insert(novaNotaEntity);}
}
