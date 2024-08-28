package com.example.ecommercemarto;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spanCount;
    private final int spacing;

    public GridSpacingItemDecoration(int spanCount, int spacing) {
        this.spanCount = spanCount;
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        outRect.left = spacing - column * spacing / spanCount; // spacing - column * (spacing / spanCount)
        outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * (spacing / spanCount)

        if (position < spanCount) { // top edge
            outRect.top = spacing;
        }
        outRect.bottom = spacing; // item bottom
    }
}