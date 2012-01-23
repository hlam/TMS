/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Customer.Grid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.customergrid',

	cls: 'customer-grid',
	disabled: false,
          
	border: false,
    
	store: 'Customers',
	requires: ['Ext.toolbar.Toolbar'],

	columns: [{
		text: 'FirstName',
		dataIndex: 'FirstName',
		width: 200
	}, {
		text: 'Country',
		dataIndex: 'Country',
		width: 200
	}, {
		text: 'State',
		dataIndex: 'State',
		width: 200
    }, {
        text: 'City',
        dataIndex: 'City',
        width: 200
    }, {
        text: 'Address',
        dataIndex: 'Address',
        width: 200
    }, {
        text: 'Fax',
        dataIndex: 'Fax',
        width: 200
    }, {
        text: 'Email',
        dataIndex: 'Email',
        width: 200
    }, {
        text: 'Mobile',
        dataIndex: 'Mobile',
        width: 200
    }, {
        text: 'Phone',
        dataIndex: 'Phone',
        width: 200
    }, {
        text: 'Zip',
        dataIndex: 'Zip',
        width: 200
    }
],
    dockedItems: [{
        xtype: 'toolbar',
        dock: 'top',
        items: [{
            text: 'Call',
            action: 'call',
            name: 'call',
            disabled:true
        }]

    }

    ,
    {
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: 'Customers',
            pageSize: 25,
            displayInfo: true

    }

    ]

});

