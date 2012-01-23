/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Login.Login', {
	extend: 'Ext.window.Window',

	alias: 'widget.loginwindow',

    requires: ['Ext.form.Panel'],


	height: 135,
	width: 300,
	title: 'Login',
	layout: 'fit',
	modal: true,
	resizable: false,
	closable: false,
    iconCls: "IconAccept",
	initComponent: function() {
		Ext.apply(this, {
			buttons: [{
				text: 'Login',
				action: 'login',
				type: 'submit',
				disabled:false
			}],

			items: [{
				xtype: 'form',
				bodyStyle: 'padding: 10px;',
				labelAlign: 'right',
				monitorValid: true,
				frame: true,
				labelWidth: 70,
				items: [{
                        xtype: 'textfield',
				        fieldLabel: 'Email',
				        name: 'login',
				        allowBlank: false,
						action: 'login'
					    },{
                        xtype: 'textfield',
				        fieldLabel: 'Password',
				        name: 'password',
				        allowBlank: true
						
					 }]
			}]


		});

		this.callParent(arguments);
	}
});

