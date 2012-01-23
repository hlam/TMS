/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Navigation.Menu', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.mainMenu',

	requires: ['Ext.toolbar.Toolbar', 'Ext.menu.Menu'],

    title: 'Navigation',
    iconCls: "IconNavigation",
	collapsible: true,
	animCollapse: true,
	margins: '5 0 5 5',
	//layout: 'fit',
	layout: 'accordion',
    items: [{
            title: "Customers and Invoices",
            trackSelection: true,
            collapsed: true,
            iconCls: "IconDocument",
            
            items: [{
                    xtype:"menu",
                    floating: false,
                    margin: '0 0 10 0',
                    
                    items: [{
                        text: "Customers",
                        iconCls: "IconUsers",
                        id: "customers",
                        classtype:"customergrid",
                        action:"customers",
                    },
                    {
                        text: "Invoices",
                        iconCls: "IconDocumentInvoice",
                        id: "invoices",
                    }]
                    
            }]
            
          }]
/*
      ,dockedItems: [{
				xtype: 'toolbar',
				items: [{
					text: 'Add Feed',
					action: 'add'
				}, {
					text: 'Remove Feed',
					disabled: true,
					action: 'remove'
				}]
			}]
		})

*/
/*    ,
	onSelectionChange: function(selmodel, selection) {
        var selected = selection[0],
            button = this.down('button[action=remove]');
        if (selected) {
            button.enable();
        }
        else {
            button.disable();
        }
	}
*/
});

