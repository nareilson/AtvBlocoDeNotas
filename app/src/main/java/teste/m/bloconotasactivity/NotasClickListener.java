package teste.m.bloconotasactivity;

import teste.m.bloconotasactivity.db.entity.NotaEntity;

public interface NotasClickListener {
    void editNotaClick();
    void eliminarNotaClick();
    void favoridaNotaClick(NotaEntity notaEntity);
}
