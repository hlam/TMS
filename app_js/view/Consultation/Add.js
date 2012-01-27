Ext.define('FV.view.Consultation.Add', {
	extend: 'Ext.window.Window',

	alias: 'widget.addConsultationWindow',

    requires: ['Ext.form.Panel', 'Ext.form.field.ComboBox'],


	width: 500,
	title: 'Новая консультация
	closeAction: 'hide',
	iconCls: 'rss',
	layout: 'fit',

	buttons: [{
				text: 'Добавить',
				action: 'create'
			}, {
				text: 'Отмена',
				scope: this,
				handler: this.close
			}],

	items: [{
				xtype: 'form',
				bodyStyle: 'padding: 10px;',
				items: [{
					itemId: 'patient',
					anchor: '0',
					fieldLabel: 'Пациент',
					labelAlign: 'top',
					msgTarget: 'under',
					xtype: 'combo',
					store: "comboPatients",
					displayField: 'name',
				    valueField: 'id'
					getInnerTpl: function() {
						return '<div class="feed-picker-url">{name}</div><div class="feed-picker-title">{age} лет {country}, {city }</div>';
					}
				}]
		}]

});

