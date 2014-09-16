package ccs.mobileapp.mobiledoctor;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeFragment extends Fragment {
	ListView lstdisease;
	public HomeFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        lstdisease = (ListView)rootView.findViewById(R.id.lstdisease);
        return rootView;
        
       
    }
	
	   	    
	  	   
	public void onActivityCreated(Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	    super.onActivityCreated(savedInstanceState);
	    
	    final ListView lstdisease = (ListView) getActivity().findViewById(
	            R.id.lstdisease);
	    
	    
	   
	}
	   
	   
	
	
	@Override
	 public void onStart(){
	 	super.onStart();
	 	//Everytime na bubuksan natin si application, tatawagin natin
	 	//si populateList() na naglalagay ng laman ng database sa listview.
	 	populateList();
	 }


	private void populateList() {
		// TODO Auto-generated method stub
		DatabaseHandler db = new DatabaseHandler(getActivity());
		 List<Disease> disease = db.getAllDisease(); 
	        ArrayList<String> arr = new ArrayList<String>();
	        for (Disease ta : disease) {
	        	arr.add(ta.getName());
	        }
	        ArrayAdapter<String> arr_adt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
	        lstdisease.setAdapter(arr_adt);
	    }
	}
	 




	