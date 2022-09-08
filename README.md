# re-GUI-Menu
GUI menu plugin (for Spigot server ; ver 1.19.2~  
  
## How to open GUI pages?  
-> Have sticks on the your mainhand, and right-click that.  
-> So, open GUI menus that are customized are opend.  
  
## Way to update GUI-pages contents without server reload.
-> When you want to reload only this plugin, if you have permission "guimenu.op", you can reload this plugins config file.  
-> Reload command is "/guimenureload".  
## Config.yml settings  
### pages  
Set how many pages are there.  
### page(x)  
Set what page is this parameter. (x) is int number start with 1.  
### items  
Set how many items are there in the page.  
### slots  
Set the number of slots that the page has.  
### storageName  
Set the name of the page.  
### item(x)  
This is a paragraph of a displayed item settings. (x) is int number start with 1.  
### materialName  
Set the items id.(You should write this parameter in UPPERCASE.)  
### displayName  
Set the items displayed name.  
### lore  
Set the items lore. If you want to write multiple lines lore, you should write "!&!" between the lore.  
If you do not need items lore, should write only "".  
## Parameters that are under this line are optional parameters.  
-> When you do not need, you do not have to write there.
### amount  
Set the items amount in range of 1 to 64.  
(When you write out of 1 to 64, will be occured bugs.)  
### jump
Set the destination page number.  
(Destination page is a page of jump to when a player click an item.)  
### command  
Set the command that run when a player click an item.
