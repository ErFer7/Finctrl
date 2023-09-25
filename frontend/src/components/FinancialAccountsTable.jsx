import { saveBank } from '../service/bankService';
import { loadAllFinancialAccounts } from '../service/financialAccountService';
import '../styles/default.css';
import { useState, useEffect } from 'react';

export default function FinancialAccountsTable() {
  const [financialAccounts, setFinancialAccounts] = useState([]);

  useEffect(() => {
    loadAllFinancialAccounts().then((data) => {
      setFinancialAccounts(data.data);
    });
  }, []);

  useEffect(() => {
    saveBank({ name: 'Banco do aaa' }).then((data) => {
      console.log(data);
    });
  }, []);

  console.log(financialAccounts)

  return (
    <>
      <table>
        <thead>
          <tr>
            <th>Conta</th>
            <th>Saldo</th>
            <th>Banco</th>
          </tr>
        </thead>
        <tbody>
          {financialAccounts.map((financialAccount) => (
            <tr key={financialAccount.id}>
              <td>{financialAccount.name}</td>
              <td>R$ {financialAccount.value / 100}</td>
              <td>{financialAccount.bankId.name}</td>
            </tr>
          ))}
        </tbody>
        <tfoot>
          <tr>
            <td colSpan="3">Total: R$ 0,00</td>
          </tr>
        </tfoot>
      </table>
    </>
  )
}
