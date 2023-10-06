// import { saveBank } from '../../service/bankService'
import { loadAllFinancialAccounts, saveFinancialAccount } from "../../service/financialAccountService"
import "../../styles/default.css"
import { useState, useEffect } from "react"
import FinancialAccountTableRow from "./FinancialAccountTableRow"

export default function FinancialAccountsTable() {
  const [financialAccounts, setFinancialAccounts] = useState([])

  useEffect(() => {
    const fetchFinancialAccounts = async () => {
      loadAllFinancialAccounts()
        .then((data) => {
          setFinancialAccounts(data.data)
        })
        .catch((error) => {
          console.log(error)
        })
    }

    fetchFinancialAccounts()
  }, [])

  function updateFinancialAccount(financialAccount) {
    const id = financialAccount.id
    if (financialAccounts[id] !== financialAccount) {
      console.log('SAVE')
      saveFinancialAccount(financialAccount).catch((error) => {
        console.log(error)
      })
    }
  }

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
            <FinancialAccountTableRow
              key={financialAccount.id}
              financialAccount={financialAccount}
              updateFinancialAccount={updateFinancialAccount}
            />
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
