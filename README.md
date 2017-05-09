# ExpandableRecycler
Hands on with Expandable Recyclerview 

# Screen Refernce
<img src="https://github.com/Aish05/ExpandableRecycler/blob/master/ExpandableRecycler.png" width="500" >

# Synopsis
Expandable RecyclerView can be used to provide expandable items.

# Highlights
Used <a href="https://medium.com/@tinmegali/model-view-presenter-mvp-in-android-part-1-441bfd7998fe"> MVP </a> Pattern for more cleaner Android Archictecture  
Fetching data from API by applying retrofit parsing  

# Usage

* We have Two ViewHolders to hold parent and child views by extending ParentViewHolder and ChildViewHolder respectively.Handle the normal ViewHolder behavior by finding any views to be held, and implement a binding method.  
* Create an adapter that extends ExpandableRecyclerAdapter and takes 4 generic types:  
  * P - The Parent Object type of your list, must implement the Parent interface
  * C - The Child Object type of your list
  * PVH - Your ViewHolder for Parent items, must extend ParentViewHolder
  * CVH - Your ViewHolder for child items, must extend ChildViewHolder
* Unlike RecyclerView.Adapter with a single set of onCreate and onBind methods, ExpandableRecyclerAdapter has a set for ParentViewHolders and another set for ChildViewHolders
* Custom Expand/Collapse Button
* The MainListItem is an Interface for implementing required methods in a parent list item.    
* MainViewHolder is the ViewHolder for a expanded state and holds callbacks which can be used to trigger expansion-based events and ChildViewHolder will be a ViewHolder for Child list.  
* MainListItemExpandCollapseListener is the interface implementation to be notified of expand/collapse state change events.  
* ExpandableRecyclerAdapterHelper is just a helper class which Generates a full list of all {MainListItem} objects and their children, in order.  
* Parent Wrapper will be used to link expanded state with a {MainListItem}.  

 
In our app, Example bean is the parent list and detail is the child list to be inflated when Parent list is expanded.  
Once parsing is done the parent list will be inflated in the MainAdapter and child list can be obtained by getChildItemList().  



# Links
<a href="https://bignerdranch.github.io/expandable-recycler-view/">https://bignerdranch.github.io/expandable-recycler-view/</a>
