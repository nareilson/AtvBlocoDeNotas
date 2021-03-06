package teste.m.bloconotasactivity.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import teste.m.bloconotasactivity.NotasClickListener;
import teste.m.bloconotasactivity.NovaNotaDialogViewModel;
import teste.m.bloconotasactivity.R;
import teste.m.bloconotasactivity.db.entity.NotaEntity;


public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<NotaEntity> notaEntityList;
    MyNotaRecyclerViewAdapter myNotaRecyclerViewAdapter;
    private NovaNotaDialogViewModel notaViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation   changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")

    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notaEntityList = new ArrayList<>();
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            myNotaRecyclerViewAdapter = new MyNotaRecyclerViewAdapter(notaEntityList, getActivity());
            recyclerView.setAdapter(myNotaRecyclerViewAdapter);

            lancarViewModel();
        }
        return view;


    }

    private void lancarViewModel() {
        notaViewModel = ViewModelProviders.of(getActivity())
                .get(NovaNotaDialogViewModel.class);
        notaViewModel.getAllNotas().observe(getActivity(), new Observer<List<NotaEntity>>() {
            @Override
            public void onChanged(@Nullable List<NotaEntity> notaEntities) {
                myNotaRecyclerViewAdapter.setNovasNotas(notaEntities);

            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu_nota_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                mostrarNovaNota();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    private void mostrarNovaNota() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        NovaNotaDialogFragment dialogFragment = NovaNotaDialogFragment.newInstance();
        dialogFragment.show(fragmentManager,"NovaNota");

    }
}
