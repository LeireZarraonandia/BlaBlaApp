package es.tta.blablatrip;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter  extends RecyclerView.Adapter<GridAdapter.ViewHolder>
{
    List<EndangeredItem> mItems;

    public GridAdapter()
    {
        super();

        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem expresiones = new EndangeredItem();
        expresiones.setName("Básicas"); ///////////////////
        expresiones.setThumbnail(R.drawable.basico);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Salud");
        expresiones.setThumbnail(R.drawable.salud);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Compras"); //////////////////
        expresiones.setThumbnail(R.drawable.compra);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Viajar y pasear"); ///////////////
        expresiones.setThumbnail(R.drawable.viajar);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Salir a comer");
        expresiones.setThumbnail(R.drawable.comer);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Hospedaje");
        expresiones.setThumbnail(R.drawable.hospedaje);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Quejas");
        expresiones.setThumbnail(R.drawable.quejas);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Coqueteo");
        expresiones.setThumbnail(R.drawable.coqueteo);
        mItems.add(expresiones);

        expresiones = new EndangeredItem();
        expresiones.setName("Números");
        expresiones.setThumbnail(R.drawable.numeros);
        mItems.add(expresiones);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_expresiones, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount()
    {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.tv_species);
        }
    }
}