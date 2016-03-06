package ru.venusgames.pavel.dreadfulyard.database.ru.venusgames.pavel.dreadfulyard.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ru.venusgames.pavel.dreadfulyard.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ListView listView = (ListView) findViewById(R.id.testListView);

        final MyItem[] myItem = new MyItem[]{
                new MyItem(R.drawable.prime, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis vel urna sit amet hendrerit. Integer justo metus, tincidunt sit amet nunc fermentum, facilisis aliquet magna. Curabitur ut placerat augue. Integer sed lorem in nulla cursus efficitur ac sit amet odio. Aliquam molestie ex ut tellus auctor porttitor. Aenean a lectus sagittis, congue ante a, porttitor mauris. Nam fermentum nulla nec ligula porttitor, et vestibulum neque tincidunt. Sed ullamcorper ullamcorper odio sit amet molestie."),
                new MyItem(R.drawable.prime, "Morbi at metus at nibh laoreet blandit vel sed dui. Ut ornare nibh aliquam posuere viverra. Curabitur semper commodo nibh. Vestibulum tempor vitae mi eu fermentum. Nullam ut leo tincidunt ligula blandit luctus. Nulla ut ligula et mauris elementum egestas vel consectetur nulla. Sed tempus, arcu in malesuada vulputate, sapien nulla tincidunt elit, in ultricies velit augue id enim."),
                new MyItem(R.drawable.prime, "Vestibulum aliquet felis id nunc pulvinar faucibus. Ut lacus leo, consectetur non malesuada id, sagittis nec mauris. Nulla facilisi. Mauris id sem leo. Etiam a odio elit. Morbi consectetur facilisis velit tincidunt elementum. Curabitur eu maximus tortor. Fusce eget tortor feugiat, gravida elit quis, rhoncus nunc. Phasellus ullamcorper aliquam urna eu lobortis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas sagittis tristique consequat. Nulla eget arcu vitae mi tincidunt tempus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."),
                new MyItem(R.drawable.prime, "Привет"),
                new MyItem(R.drawable.prime, "Друг"),
        };

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return myItem.length;
            }

            @Override
            public Object getItem(int position) {
                return myItem[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = convertView;
                if (view == null) {
                    LayoutInflater layoutInflater = (LayoutInflater) ListViewActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                    view = layoutInflater.inflate(R.layout.test_image_texts_layout, parent, false);
                    ViewHolder viewHolder = new ViewHolder();
                    viewHolder.imageView = (ImageView) view.findViewById(R.id.avatar);
                    viewHolder.textView = (TextView) view.findViewById(R.id.message);
                    setData(position, viewHolder);
                    view.setTag(viewHolder);
                } else {
                    ViewHolder viewHolder = (ViewHolder) view.getTag();
                    setData(position, viewHolder);
                }
                return view;
            }

            private void setData(int position, ViewHolder viewHolder) {
                MyItem item = (MyItem) getItem(position);
                viewHolder.imageView.setImageResource(item.image);
                viewHolder.textView.setText(item.text);
            }
        });
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    class MyItem {
        int image;
        String text;

        public MyItem(int image, String text) {
            this.image = image;
            this.text = text;
        }
    }
}
