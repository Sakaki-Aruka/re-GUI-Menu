# re-GUI-Menu
GUI menu plugin (for Spigot server ; ver 1.19.2~  
  
## How to open GUI pages?  
-> Have sticks on the your mainhand, and right-click that.  
-> So, open GUI menus that are customized are opend.  
  
## Way to update GUI-pages contents without server reload.
-> When you want to reload only this plugin, if you have permission "guimenu.op", you can reload this plugins config file.  
-> Reload command is "/guimenureload". 
## How to update GUI menus?  
-> Run "/guimenureload" command.  
(To send this command allowed only for administrators or the limited players who have the permission that is "guimenu.op".)    
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
### amount  
Set the items amount in range of 1 to 64.  
(When you write out of 1 to 64, will be occured bugs.)  
### command  
Set the command(or chat message) that run when a player click an item.  
This parameters default value is "". (no work)   
### jump
Set the destination page number.  
(Destination page is a page of jump to when a player click an item.)   
default value is 0.(if set 0 in this parameter, will not jump to anywhere.)
