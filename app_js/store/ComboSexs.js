Ext.define('WebApp.store.ComboSexs', {
	storeId:'comboSexs',
	extend: 'Ext.data.Store',
    data:[
          { code: "M",   name: 'Мужчина' },
          { code: "F",   name: 'Женшина' }
      ]
	,fields:[
        'code','name'                        
    ]
});
