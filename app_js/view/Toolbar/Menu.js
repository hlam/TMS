
Ext.define('WebApp.view.ToolBar.Menu', {
    extend: 'Ext.toolbar.Toolbar',
    alias: 'widget.toolbarmenu',
    xtype:"toolbar",
    height:25,
    margins:"0 0 4 0",
    items: [{
        xtype: "label",
        html: "<b>TMS </b> (1.0 RC)",
        cls: "title-label",
        iconCls: "IconApplication"
    },
     { xtype: "tbfill" },
    {
        xtype: "label",
        html: "<b>"+(AppGlobalSetting.CurrentUser?AppGlobalSetting.CurrentUser.name:"")+"</b>",
        cls: "title-label",
        id:"main_username"
    },

	  {
	      text: "Settings",
          iconCls: "IconSettings",
          menu: [{
	          disabled: true,
	          iconCls: "IconPorfile",
	          text: "Profile"
	      },
				{
				    iconCls: "IconOptions",
				    text: "Options"
				}]
          
	  },
		{
		    iconCls: "IconHelp",
	        text: "Help",

	        menu: [{ iconCls: "IconBug", text: "Report a Defect" },
					{ iconCls: "IconInformation", text: "About"}]
          
		},
		{ xtype: "tbseparator" },
		{
		    iconCls: "IconLogout",
		    text: "Logout",
		    action: "logout",
		}
    ]
});

