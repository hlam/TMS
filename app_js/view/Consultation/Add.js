Ext.define('WebApp.view.Consultation.Add', {
	extend: 'Ext.window.Window',

	alias: 'widget.addconsultationwindow',

    requires: ['Ext.form.Panel', 'Ext.form.field.ComboBox'],


	width: 500,
	title: 'Новая консультация',
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
					itemId: 'patient_id',
					name: 'patient_id',
					anchor: '0',
					fieldLabel: 'Пациент',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "ComboPatients",
					displayField: 'name',
				    valueField: 'id',
	                emptyText: 'Выберите...',
					allowBlank: false,
					listConfig: {
		                loadingText: 'Searching...',
		                emptyText: 'No matching posts found.',
	
		                // Custom rendering template for each item
		                getInnerTpl: function() {
							return '<div class="feed-picker-url"><b>{name}</b></div><div class="feed-picker-title">{age} лет {country}, {city}</div>';
		                }
		            },
				},
				{
					fieldLabel: 'Предварительный диагноз',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textarea',
					allowBlank: false,
					name:"diagnosIn"
				},{
					itemId: 'speciality_id',
					name: 'speciality_id',
					anchor: '0',
					fieldLabel: 'Специальность',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "Specialities",
					queryMode: 'local',
					displayField: 'name',
				    valueField: 'id',
				    typeAhead: true,
	                emptyText: 'Выберите...',
					allowBlank: false,
	                forceSelection:true
				},{
					itemId: 'advisor_id',
					name: 'advisor_id',
					anchor: '0',
					fieldLabel: 'Консультант',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "ComboAdvisors",
					displayField: 'name',
				    valueField: 'id',
	                emptyText: 'Выберите...',
					allowBlank: false,
					listConfig: {
		                loadingText: 'Searching...',
		                emptyText: 'No matching posts found.',
	
		                // Custom rendering template for each item
		                getInnerTpl: function() {

							return '<div class="feed-picker-url">{rank} <b>{name}</b></div><div class="feed-picker-title">{speciality} в {lpzName}, {lpzCity}</div>';
		                }
		            },
				},
				{
					fieldLabel: 'Вопрос консультанту',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'textarea',
					allowBlank: false,
					name:"question"
				},
				{
					fieldLabel: 'Дата свежести',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'datefield',
					minValue: new Date(),
					name:"dateRes"
				},
				{
					fieldLabel: 'Цена вопроса',
					anchor: '0',
					labelAlign: 'top',
					xtype: 'numberfield',
					allowDecimals: true,
	                decimalPrecision: 2,
	                hideTrigger: true,
	                minValue: 1,
					name:"price"
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

