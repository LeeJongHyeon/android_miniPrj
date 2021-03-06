package com.example.ljh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class ShopFragment extends Fragment {

    ProductAdapter adapter;
    GridView gridView1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shop, container, false);
        gridView1 = v.findViewById(R.id.gridView1);
        setNormalGridView();
        return v;
    }

    private void setNormalGridView() {

        adapter = new ProductAdapter();

        adapter.addItem(new ProductItem("토끼털 코트", "리본", 7, 574770, R.drawable.clothes1));
        adapter.addItem(new ProductItem("어깨 패치 H라인 원피스", "헤지스레이디스", 19, 297580, R.drawable.clothes2));
        adapter.addItem(new ProductItem("그린체크 패턴 소매배색 긴팔 남방", "헤지스레이디스", 16, 144500, R.drawable.clothes3));
        adapter.addItem(new ProductItem("네이비 마드라스 체크 퍼피 남방", "헤지스레이디스", 16, 170150, R.drawable.clothes4));

        gridView1.setAdapter(adapter);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductItem item = (ProductItem) adapter.getItem(position);
                Toast.makeText(getActivity(), "선택된 제품 : " + item.getName(), Toast.LENGTH_LONG).show();

            }

        });

    }

    class ProductAdapter extends BaseAdapter {
        ArrayList<ProductItem> items = new ArrayList<ProductItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ProductItem item) {
            items.add(item);
        }

        public void removeItem(int position) {
            items.remove(position);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ProductItemView view = null;
            if (convertView == null) {
                view = new ProductItemView(getContext());
            } else {
                view = (ProductItemView) convertView;
            }

            ProductItem item = items.get(position);
            view.setName("[" + item.getManufacturer() + "] " + item.getName());
            view.setCountAgent("업체 " + item.getCountAgent());
            view.setPrice(String.valueOf(item.getPrice()));
            view.setImage(item.getImageRes());

            return view;
        }

    }



}
