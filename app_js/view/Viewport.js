/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'WebApp.view.Viewer',
        'WebApp.view.Navigation.Menu',
        'WebApp.view.ToolBar.Menu'
    /*
    'Ext.layout.container.Border'
    */
    ],

	layout: 'border',

	items: [{
		region: 'center',
		xtype: 'viewer'
	}, {
		region: 'west',
		width: 225,
		xtype: 'mainMenu'
	}, {
		region: 'north',
		xtype: 'toolbarmenu'
    }],
    bbar:[{
    region: 'south',
    xtype: 'statusbar',
    defaultText: 'Ready',
     id: 'main-statusbar',
      statusAlign: 'right' // the magic config
}],
});

