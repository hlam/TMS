
Ext.define('WebApp.model.Country', {
    extend: 'Ext.data.Model',
        proxy: {
        type: 'rest',
        url: 'Country/combo'
    },
    fields: [ 'name', 'id' ]
});
