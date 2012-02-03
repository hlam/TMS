/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Patient.Grid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.patientgrid',
	cls: 'patient-grid',
	disabled: false,
          
	border: false,
    
	store: 'Patients',
	requires: ['Ext.toolbar.Toolbar','Ext.ux.PreviewPlugin'],

	columns: [{
		text: 'Пациет',
		dataIndex: 'name',
		width: 200

	}, {
		text: 'Пол',
		dataIndex: 'sex'
	}, {
		text: 'Возраст',
		dataIndex: 'age'
    },{
		text: 'Страна',
		dataIndex: 'country'
    },{
		text: 'Город',
		dataIndex: 'city'
    },
     {
        text: 'Сатус',
        dataIndex: 'status',
        width: 70
    }
],
    dockedItems: [{
        xtype: 'toolbar',
        dock: 'top',
        items: [{
            text: 'Добавить',
            action: 'add',
            name: 'add_patient',
            disabled:false
        }]

    }
    ,
    {
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: 'Patients',
            pageSize: 25,
            displayInfo: true

    }
    ]

});

