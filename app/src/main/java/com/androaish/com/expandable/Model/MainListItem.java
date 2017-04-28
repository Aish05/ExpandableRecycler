package com.androaish.com.expandable.Model;

/**
 * Created by 848764 on 9/15/2016.
 */
import java.util.List;

/**
 * Interface for implementing required methods in a parent list item.
 */
public interface MainListItem {

    /**
     * Getter for the list of this parent list item's child list items.
     * <p>
     * If list is empty, the parent list item has no children.
     *
     * @return A {@link List} of the children of this {@link MainListItem}
     */
    List<?> getChildItemList();

    /**
     * Getter used to determine if this {@link MainListItem}'s
     * {@link android.view.View} should show up initially as expanded.
     *
     * @return true if expanded, false if not
     */
    boolean isInitiallyExpanded();
}
