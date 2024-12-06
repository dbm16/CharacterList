package com.dbm.task1.ui;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dbm.task1.R;
import com.dbm.task1.adapters.CharacterAdapter;
import com.dbm.task1.models.Character;

import java.util.ArrayList;
import java.util.List;

public class Charcter_List extends AppCompatActivity {

        private CharacterAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_charcter_list);

            List<com.dbm.task1.models.Character> characters = new ArrayList<>();
            characters.add(new com.dbm.task1.models.Character("טימון ופומבה", "צמד חברים מהסרט מלך האריות", R.drawable.timon));
            characters.add(new com.dbm.task1.models.Character("סימבה", "האריה הצעיר והמלך העתידי במלך האריות", R.drawable.simba));
            characters.add(new com.dbm.task1.models.Character("בובספוג", "הספוג הצהוב המצחיק שעובד במסעדת קציצת הסרטן", R.drawable.spong));
            characters.add(new com.dbm.task1.models.Character("פטריק", "הכוכב הוורוד והחבר הכי טוב של בובספוג", R.drawable.patrick));
            characters.add(new com.dbm.task1.models.Character("סקווידוויד", "השכן הנגן של בובספוג ופטריק", R.drawable.squ));
            characters.add(new com.dbm.task1.models.Character("סקובי-דו", "הכלב הפחדן שמוביל חבורת בלשים", R.drawable.scooby));
            characters.add(new com.dbm.task1.models.Character("באז שנות אור", "החללית והגיבור מ'צעצוע של סיפור'", R.drawable.buzz));
            characters.add(new com.dbm.task1.models.Character("וודי", "הקאובוי האמיץ מ'צעצוע של סיפור'", R.drawable.woody));
            characters.add(new com.dbm.task1.models.Character("מיקי מאוס", "העכבר האייקוני מסרטי דיסני", R.drawable.micky));
            characters.add(new Character("ספיידרמן", "איש הקירות וגיבור על", R.drawable.spider));

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new CharacterAdapter(this, characters);
            recyclerView.setAdapter(adapter);

            EditText searchEditText = findViewById(R.id.search_edit_text);
            searchEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }