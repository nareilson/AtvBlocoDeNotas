package teste.m.bloconotasactivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import teste.m.bloconotasactivity.db.entity.NotaEntity;

public class NovaNotaDialogFragment extends DialogFragment {

    public static NovaNotaDialogFragment newInstance() {
        return new NovaNotaDialogFragment();
    }

    private View view;
    private EditText edTitulo;
    private EditText edConteudo;
    private RadioGroup rgCor;
    private Switch swFavorito;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nova_nota_dialog_fragment, container, false);
    }


    //Criando o Dialogo
    public Dialog OnCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Setando os botões e mensagem de dialogo
        builder.setTitle("Nova Nata");
        builder.setMessage("Introduza od dados da nova nota")
                .setPositiveButton("Salvar ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String titulo = edTitulo.getText().toString();
                        String conteudo = edConteudo.getText().toString();
                        boolean favorido = swFavorito.isChecked();
                        String cor = "azul";
                        switch (rgCor.getCheckedRadioButtonId()) {
                            case R.id.radioButtonAzul:
                                cor = "azul";
                                break;
                            case R.id.radioButtonVerde:
                                cor = "verde";
                                break;
                            case R.id.radioButtonVermelho:
                                cor = "vermelho";
                                break;
                            default:
                                cor = "azul";
                                break;
                        }
                        //Comunicando a viewModel com o novo dado
                        NovaNotaDialogViewModel mViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(NovaNotaDialogViewModel.class);
                        mViewModel.inserteNota(new NotaEntity(titulo, conteudo, favorido, cor));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        //setando o Layout de nossa caixa de Dalogo
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nova_nota_dialog_fragment, null);

        edTitulo = view.findViewById(R.id.editTextTitulo);
        edConteudo = view.findViewById(R.id.editTextConteudo);
        rgCor = view.findViewById(R.id.radioGroup);
        swFavorito = view.findViewById(R.id.switchFavorito);


        builder.setView(view);

        return builder.create();
    }

}
