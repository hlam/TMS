/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.define('WebApp.view.Consultation.Grid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.consultationgrid',
	cls: 'consultation-grid',
	disabled: false,
          
	border: false,
    
	store: 'Consultations',
	requires: ['Ext.toolbar.Toolbar','Ext.ux.PreviewPlugin'],

	columns: [{
		text: 'Пациет',
		dataIndex: 'patient.name',
		width: 200
	}, {
		text: 'Спецальность',
		dataIndex: 'history.speciality.name',
		width: 200
	}, {
		text: 'Консультант',
		dataIndex: 'history.advisor.name',
		width: 200
    }, {
        text: 'Создана',
        dataIndex: 'dateIn',
        width: 200
    }, {
        text: 'До',
        dataIndex: 'dateRes',
        width: 200
    }, {
        text: 'ICD10',
        dataIndex: 'ICD10',
        width: 200
    }, {
        text: 'Сатус',
        dataIndex: 'status',
        width: 200
    }
],
	// pluggable renders
	viewConfig: {
	    id: 'gv',
	    trackOver: false,
	    stripeRows: false,
	    plugins: [{
	        ptype: 'preview',
	        bodyField: 'diagnosIn',
	        expanded: true,
	        pluginId: 'preview'
	    }]
	},
    dockedItems: [{
        xtype: 'toolbar',
        dock: 'top',
        items: [{
            text: 'Добавить',
            action: 'add',
            name: 'add_consultation',
            disabled:false
        }]

    }

    ,
    {
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: 'Consultations',
            pageSize: 25,
            displayInfo: true

    }

    ]

});

