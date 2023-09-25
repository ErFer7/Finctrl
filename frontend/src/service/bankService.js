import api from './api'

export const loadBankById = async (id) => await api.get(`/bank/${id}`)

export const saveBank = async (data) => await api.post('/bank/save', data)