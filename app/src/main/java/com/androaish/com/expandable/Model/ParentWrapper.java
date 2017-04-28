package com.androaish.com.expandable.Model;

import java.util.List;

/**
 * Wrapper used to link expanded state with a {@link MainListItem}.
 */
public class ParentWrapper {

    private boolean mExpanded;
    private MainListItem mMainListItem;

    /**
     * Default constructor.
     *
     * @param mMainListItem The {@link MainListItem} to wrap
     */
    public ParentWrapper(MainListItem mMainListItem) {
        this.mMainListItem = mMainListItem;
        mExpanded = false;
    }

    /**
     * Gets the {@link MainListItem} being wrapped.
     *
     * @return The {@link MainListItem} being wrapped
     */
    public MainListItem getMainListItem() {
        return mMainListItem;
    }

    /**
     * Sets the {@link MainListItem} to wrap.
     *
     * @param mMainListItem The {@link MainListItem} to wrap
     */
    public void setMainListItem(MainListItem mMainListItem) {
        mMainListItem = mMainListItem;
    }

    /**
     * Gets the expanded state associated with the {@link MainListItem}.
     *
     * @return true if expanded, false if not
     */
    public boolean isExpanded() {
        return mExpanded;
    }

    /**
     * Sets the expanded state associated with the {@link MainListItem}.
     *
     * @param expanded true if expanded, false if not
     */
    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    public boolean isInitiallyExpanded() {
        return mMainListItem.isInitiallyExpanded();
    }

    public List<?> getChildItemList() {
        return mMainListItem.getChildItemList();
    }
}
