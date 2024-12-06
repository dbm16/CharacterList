package com.dbm.task1;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Charcter_List extends AppCompatActivity {

        private CharacterAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_charcter_list);

                    List<Character> characters = new ArrayList<>();
            characters.add(new Character("טימון ופומבה", "צמד חברים מהסרט מלך האריות", R.drawable.timon));
            characters.add(new Character("סימבה", "האריה הצעיר והמלך העתידי במלך האריות", R.drawable.simba));
            characters.add(new Character("בובספוג", "הספוג הצהוב המצחיק שעובד במסעדת קציצת הסרטן", R.drawable.spong));
            characters.add(new Character("פטריק", "הכוכב הוורוד והחבר הכי טוב של בובספוג", R.mipmap.ic_launcher));
            characters.add(new Character("סקווידוויד", "השכן הנרגן של בובספוג ופטריק", R.mipmap.ic_launcher));
            characters.add(new Character("סקובי-דו", "הכלב הפחדן שמוביל חבורת בלשים", R.mipmap.ic_launcher));
            characters.add(new Character("באז שנות אור", "החללית והגיבור מ'צעצוע של סיפור'", R.drawable.buzz));
            characters.add(new Character("וודי", "הקאובוי האמיץ מ'צעצוע של סיפור'", R.drawable.woody));
            characters.add(new Character("שראגי", "החבר הטוב של סקובי-דו ואוהב חטיפים", R.mipmap.ic_launcher));
            characters.add(new Character("הומר סימפסון", "אבא מצחיק ממשפחת סימפסון", R.mipmap.ic_launcher));

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