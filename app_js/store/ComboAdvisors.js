Ext.define('WebApp.store.ComboAdvisors', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.ComboAdvisor',
    fields:['speciality_id'],
    pageSize: 10
});
