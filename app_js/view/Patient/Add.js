Ext.define('WebApp.view.Patient.Add', {
	extend: 'Ext.window.Window',

	alias: 'widget.addpatientwindow',

    requires: ['Ext.form.Panel', 'Ext.form.field.ComboBox'],


	width: 500,
	title: 'Новый пациент',
	closeAction: 'hide',
	iconCls: 'rss',
	layout: 'fit',

	buttons: [{
				text: 'Добавить',
				action: 'add'
			}, {
				text: 'Отмена',
				action: 'close'
			}],

	items: [{
				xtype: 'form',
				bodyStyle: 'padding: 10px;',
				items: [
						{
							fieldLabel: 'ФИО',
							anchor: '0',
							labelAlign: 'top',
							xtype: 'textfield',
						    hideTrigger: true,
						    llowBlank: false,
							name:"name"
						},
				  {
					itemId: 'sex',
					name: 'sex',
					anchor: '0',
					fieldLabel: 'Пол',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "ComboSexs",
					displayField: 'name',
				    valueField: 'code',
	                emptyText: 'Выберите...',
					allowBlank: false
				},
				{
					fieldLabel: 'День рождения',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'datefield',
					maxValue: new Date(),
					name:"birthday"
				},
				{
					itemId: 'country_id',
					name: 'country_id',
					anchor: '0',
					fieldLabel: 'Страна',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "Countries",
					queryMode: 'local',
					displayField: 'name',
				    valueField: 'id',
				    typeAhead: true,
	                emptyText: 'Выберите...',
					allowBlank: false,
	                forceSelection:true
				},
				{
					fieldLabel: 'Индекс',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textfield',
				    hideTrigger: true,
				    llowBlank: false,
					name:"zipCode"
				},
				{
					fieldLabel: 'Город',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textfield',
				    hideTrigger: true,
				    llowBlank: false,
					name:"city"
				},
				{
					fieldLabel: 'Адресс',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textarea',
					allowBlank: false,
					llowBlank: false,
					name:"address"
				},
				{
					fieldLabel: 'Адресс 2',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textarea',
					
					name:"address1"
				},
				{
					fieldLabel: 'Телефон',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textfield',
				    hideTrigger: true,
				    llowBlank: false,
					name:"tel"
				}
								/*
				 select:{fn:function(combo, value) {
                        var comboCity = Ext.getCmp('combo-city');        
                        comboCity.clearValue();
                        comboCity.store.filter('cid', combo.getValue());
                        }}
				 */
				]
		}]

});

