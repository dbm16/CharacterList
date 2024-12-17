package com.dbm.task1.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dbm.task1.R;
import com.dbm.task1.adapters.CharacterAdapter;
import com.dbm.task1.models.Character;

import java.util.ArrayList;
import java.util.List;

public class Character_List_Fragment extends Fragment {

    private CharacterAdapter adapter;

    public Character_List_Fragment() {
    }

    public static Character_List_Fragment newInstance() {
        return new Character_List_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character__list_, container, false);

        // Initialize data
        List<Character> characters = new ArrayList<>();
        characters.add(new Character("בובספוג מכנסמרובע", "בחור אופטימי וחיובי שתמיד מחייך. עובד קשה במסעדת המבורגרים אבל לפעמים קצת מעצבן את החברים שלו עם השטויות שלו.", R.drawable.spong));
        characters.add(new Character("פטריק כוכב", "החבר הכי טוב של בובספוג. הוא די עצלן ולא תמיד מבין מה קורה סביבו, אבל יש לו לב ענק ותמיד מוכן לעזור.", R.drawable.patrick));
        characters.add(new Character("סקווידוויד טנטקלס", "שכן של בובספוג ופטריק. תמיד נראה עצבני ועייף. הוא אוהב לנגן בקלרינט וחולם על חיים שקטים בלי רעש.", R.drawable.squ));
        characters.add(new Character("מר קראב", "המנהל של מסעדת קציצת הסרטן. איש עסקים ממולח שכל מה שמעניין אותו זה כסף. לפעמים הוא קצת קמצן, אבל יש לו גם צד רך, בעיקר כלפי הבת שלו.", R.drawable.krab));
        characters.add(new Character("סנדי צ'יקס", "חברה טובה של בובספוג. היא מדענית שאוהבת הרפתקאות וספורט. סנדי תמיד מוכנה ללמד את בובספוג דברים חדשים, בעיקר על עולם היבשה.", R.drawable.sandy));
        characters.add(new Character("פרל קראב", "הבת של מר קראב. נערה מתבגרת שאוהבת אופנה ושופינג. לפעמים היא מתעצבנת על אבא שלה כשהוא מתנהג בצורה מביכה.", R.drawable.pearl));
        characters.add(new Character("שלדון פלנקטון", "האויב המושבע של מר קראב. מנסה לגנוב את המתכון הסודי של קציצת הסרטן. הוא חכם, אבל התוכניות שלו תמיד נכשלות.", R.drawable.plankton));
        characters.add(new Character("גארי החילזון", "החבר הכי נאמן של בובספוג. הוא לא מדבר, אבל המבט שלו אומר הכול. בובספוג אוהב אותו מאוד.", R.drawable.gary));
        characters.add(new Character("גברת פאף", "המורה של בובספוג בבית הספר לנהיגה. היא תמיד בלחץ ממנו כי הוא נהג נוראי שגורם לה כאב ראש.", R.drawable.mrs_puff));
        characters.add(new Character("קארן", "האישה של פלנקטון. מחשב חכם שתמיד נותן לו עצות, אבל לפעמים היא צוחקת עליו כשהוא נכשל.", R.drawable.karen));

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CharacterAdapter(getContext(), characters);
        recyclerView.setAdapter(adapter);

        EditText searchEditText = view.findViewById(R.id.search_edit_text);
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

        return view;
    }
}
