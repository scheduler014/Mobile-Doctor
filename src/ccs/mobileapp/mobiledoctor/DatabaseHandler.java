package ccs.mobileapp.mobiledoctor;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
	 
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbDisease";
    private static final String TABLE_DISEASE = "tblDisease";
 
    private static final String FIELD_ID = "col_id";
    private static final String FIELD_NAME = "col_name";
    private static final String FIELD_DESCRIPTION = "col_desc";
    private static final String FIELD_SYMPTOM = "col_symptom";
    private static final String FIELD_SOLUTION = "col_solution";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_DISEASE + "("
                + FIELD_ID + " INTEGER PRIMARY KEY," + FIELD_NAME + " TEXT," + FIELD_DESCRIPTION + " TEXT,"+ FIELD_SYMPTOM + " TEXT,"+ FIELD_SOLUTION + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISEASE);
        onCreate(db);
    }
 
    void addDisease(Disease disease) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, disease.getName());
        values.put(FIELD_DESCRIPTION, disease.getDesc());
        values.put(FIELD_SYMPTOM, disease.getSymp());
        values.put(FIELD_SOLUTION, disease.getSolu());
        db.insert(TABLE_DISEASE, null, values);
        db.close();
    }
 
    public List<Disease> getAllDisease() {
        List<Disease> diseaseList = new ArrayList<Disease>();
        String selectQuery = "SELECT  * FROM " + TABLE_DISEASE;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        if (cursor.moveToFirst()) {
            do {
                Disease disease = new Disease();
                disease.setID(Integer.parseInt(cursor.getString(0)));
                disease.setName(cursor.getString(1));
                
                diseaseList.add(disease);
            } while (cursor.moveToNext());
        }
        return diseaseList;
    }
    
 
 
}
	
