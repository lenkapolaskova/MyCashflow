package com.example.mycashflow;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.ref.WeakReference;

public class SecondFragment extends Fragment {

    static TextView cashplusview = null;
    static TextView cashminusview = null;
    static TextView cashview = null;
    View view = null;
    static final String LOG_TAG = "SecondFragment";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second, container, false);
        cashplusview = view.findViewById(R.id.textViewCashflowplus);
        cashminusview = view.findViewById(R.id.textViewCashflowMinus);
        cashview = view.findViewById(R.id.textViewCashflow);
        cashplusview.setText("Ahoj");
        cashminusview.setText("Hi");
        cashview.setText("Helo");

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        new FragmentAsyncTask().execute();
    }

    private class FragmentAsyncTask extends AsyncTask<Void, Void, Integer> {


        public FragmentAsyncTask() {
        }

        @Override
        protected Integer doInBackground(Void... params) {
            int cashflowplus = 0, cashflowminus = 0, cashflow = 0;
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            CashflowTable lastEntry = db.cashflowDao().getLastEntry();
            cashflowplus = lastEntry.getCashflowplus();
            cashflowminus = lastEntry.getCashflowminus();
            cashplusview.setText(Integer.toString(cashflowplus)); // TODO: osetrit ze se nic nepokaka
            cashminusview.setText(Integer.toString(cashflowminus)); // TODO: osetrit ze se nic nepokaka
            //cashview.setText(Integer.toString(cashflow)); // TODO: osetrit ze se nic nepokaka
            Log.d(LOG_TAG, "cashflow inserted plus " + cashflowplus + "minus " + cashflowminus + "cashflow " + cashflow);
            return 0;
        }

        protected void onProgressUpdate(Integer... progress) {
            Log.d(LOG_TAG, "On progress update");
        }

        @Override
        protected void onPostExecute(Integer agentsCount) {
            /* Activity activity = weakActivity.get();
            Log.d(LOG_TAG, "On post activity");
            if(activity == null) {
                return;
            }*/
        }
    }
}