package ccs.mobileapp.mobiledoctor;

import java.util.ArrayList;


import android.support.v4.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeFragment extends ListFragment {
	ListView lstdisease;
	private static final String DB_DISEASE = "dbDisease.sqlite3";
	private static final String TABLE_DISEASE = "tblDisease";
    private static final String FIELD_ID = "col_id";
    private static final String FIELD_NAME = "col_name";
	private SQLiteDatabase database;
	private ArrayList<String> disease;
	public HomeFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        return rootView;
        
       
    }
	
	   	    
	  	   
	public void onActivityCreated(Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	    super.onActivityCreated(savedInstanceState);
	    
	   
	    

	    populateList();
	 	filldisease();
	}
	   
	   private void populateList() {
		DatabaseHandler dbOpenHelper = new DatabaseHandler(getActivity(), DB_DISEASE);
        database = dbOpenHelper.openDataBase();
        setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, disease));
       lstdisease = getListView();
	}
	
	
	private void filldisease() {
		disease = new ArrayList<String>();
		Cursor diseaseCursor = database.query(TABLE_DISEASE,
											 new String[] 
											 {FIELD_ID , FIELD_NAME},
											 null, null, null, null
											 , FIELD_NAME);
		diseaseCursor.moveToFirst();
		if(!diseaseCursor.isAfterLast()) {
			do {
				String name = diseaseCursor.getString(1);
				disease.add(name);
			} while (diseaseCursor.moveToNext());
		}
		diseaseCursor.close();
	}
}
	 




	