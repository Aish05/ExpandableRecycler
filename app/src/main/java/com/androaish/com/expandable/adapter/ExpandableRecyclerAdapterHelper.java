package com.androaish.com.expandable.adapter;

/**
 * Created by 848764 on 9/15/2016.
 */


import com.androaish.com.expandable.Model.MainListItem;
import com.androaish.com.expandable.Model.ParentWrapper;

import java.util.ArrayList;
import java.util.List;



/**
 * Helper for {@link ExpandableRecyclerAdapter}.
 *
 * Created by Ryan Brooks on 6/11/15.
 */
public class ExpandableRecyclerAdapterHelper {

    /**
     * Generates a full list of all {@link MainListItem} objects and their
     * children, in order.
     *
     * @param parentItemList A list of the {@code MainListItem} objects from
     *                       the {@link ExpandableRecyclerAdapter}
     * @return A list of all {@code MainListItem} objects and their children, expanded
     */
    public static List<Object> generateParentChildItemList(List<? extends MainListItem> parentItemList) {
         List<Object> parentWrapperList = new ArrayList<>();
        MainListItem mainListItem;
        ParentWrapper parentWrapper;

        int MainListItemCount = parentItemList.size();
        for (int i = 0; i < MainListItemCount; i++) {
            mainListItem = parentItemList.get(i);
            parentWrapper = new ParentWrapper(mainListItem);
            parentWrapperList.add(parentWrapper);

            if (parentWrapper.isInitiallyExpanded()) {
                parentWrapper.setExpanded(true);

                int childListItemCount = parentWrapper.getChildItemList().size();
                for (int j = 0; j < childListItemCount; j++) {
                    parentWrapperList.add(parentWrapper.getChildItemList().get(j));
                }
            }
        }

        return parentWrapperList;
    }
}
