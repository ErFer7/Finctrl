import api from './api'

export const loadFinancialAccountById = async (id) => await api.get(`/financialaccount/${id}`)

export const loadAllFinancialAccounts = async () => await api.get('/financialaccount/all')

export const saveFinancialAccount = async (data) =>
  await api.post('/financialaccount/save', data, { headers: { 'Content-Type': 'application/json' } })
