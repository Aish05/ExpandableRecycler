package com.androaish.com.expandable.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder for a expanded state and holds callbacks which can be used to
 * trigger expansion-based events.
 * <p/>
 * Created by Aish on 9/15/2016.
 */
public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private MainListItemExpandCollapseListener mMainListItemExpandCollapseListener;
    private boolean mExpanded;



    /*
     * implementations to be notified of expand/collapse state change events.
     */
    public interface MainListItemExpandCollapseListener {

        /**
         * Called when a list item is expanded.
         *
         * @param position The index of the item in the list being expanded
         */
        void onMainListItemExpanded(int position);

        /**
         * Called when a list item is collapsed.
         *
         * @param position The index of the item in the list being collapsed
         */
        void onMainListItemCollapsed(int position);
    }

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public MainViewHolder(View itemView) {
        super(itemView);
        mExpanded = false;
    }

    /**
     * Sets a {@link android.view.View.OnClickListener} on the entire parent
     * view to trigger expansion.
     */
    public void setMainItemClickToExpand() {
        itemView.setOnClickListener(this);
    }

    /**
     * Returns expanded state
     *
     * @return true if expanded, false if not
     */
    public boolean isExpanded() {
        return mExpanded;
    }

    /**
     * Setter method for expanded state, used for initialization of expanded state.
     * changes to the state are given in {@link #onExpansionToggled(boolean)}
     *
     * @param expanded true if expanded, false if not
     */
    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    /**
     * Callback triggered when expansion state is changed, but not during
     * initialization.
     * <p/>
     * Useful for implementing animations on expansion.
     *
     * @param expanded true if view is expanded before expansion is toggled,
     *                 false if not
     */
    public void onExpansionToggled(boolean expanded) {

    }

    /**
     * Getter for the ExpandCollapseListener
     *
     * @return The ExpandCollapseListener set in the {@link MainViewHolder}
     */
    public MainListItemExpandCollapseListener getMainListItemExpandCollapseListener() {
        return mMainListItemExpandCollapseListener;
    }

    /**
     * Setter for theExpandCollapseListener implemented ineRecyclerAdapter
     *
     * @param MainListItemExpandCollapseListener The {@link MainListItemExpandCollapseListener} to set on the {@link MainViewHolder
     * }
     */
    public void setMainListItemExpandCollapseListener(MainListItemExpandCollapseListener MainListItemExpandCollapseListener) {
        mMainListItemExpandCollapseListener = MainListItemExpandCollapseListener;
    }

    /**
     * {@link android.view.View.OnClickListener} to listen for click events on
     * the entire parent {@link View}.
     * <p/>
     * Only registered if {@link #shouldItemViewClickToggleExpansion()} is true.
     *
     * @param v The {@link View} that is the trigger for expansion
     */
    @Override
    public void onClick(View v) {
        if (mExpanded) {
         collapseView();
        } else {
            //expandViewWithCollapse();
            expandView();
        }
    }

    /**
     * Used to determine whether a click in the entire parent {@link View}
     * should trigger row expansion.
     * <p/>
     * If you return false, you can call {@link #expandView()} to trigger an
     * expansion in response to a another event or {@link #collapseView()} to
     * trigger a collapse.
     *
     * @return true to set an {@link android.view.View.OnClickListener} on the item view
     */
    public boolean shouldItemViewClickToggleExpansion() {
        return true;
    }

    /**
     * Triggers expansion of the parent.
     */
    protected void expandView() {
        setExpanded(true);
        onExpansionToggled(false);

        if (mMainListItemExpandCollapseListener != null) {
            mMainListItemExpandCollapseListener.onMainListItemExpanded(getAdapterPosition());
        }
    }

    /**
     * Triggers collapse of the parent.
     */
    protected void collapseView() {
        setExpanded(false);
        onExpansionToggled(true);

        if (mMainListItemExpandCollapseListener != null) {
            mMainListItemExpandCollapseListener.onMainListItemCollapsed(getAdapterPosition());
        }
    }

    /**
     * Triggers expansion of the parent with other items to collapse.
     */
    protected void expandViewWithCollapse() {
        setExpanded(true);
        onExpansionToggled(false);

        if (mMainListItemExpandCollapseListener != null) {
            mMainListItemExpandCollapseListener.onMainListItemExpanded(getAdapterPosition());
            mMainListItemExpandCollapseListener.onMainListItemCollapsed(getOldPosition());
        }
    }
}