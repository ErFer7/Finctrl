import PropTypes from 'prop-types'
import { useState } from 'react'

FinancialAccountTableRow.propTypes = {
  financialAccount: PropTypes.shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    value: PropTypes.number.isRequired,
    bankId: PropTypes.shape({
      name: PropTypes.string.isRequired,
    }).isRequired,
  }).isRequired,
  updateFinancialAccount: PropTypes.func.isRequired,
}

export default function FinancialAccountTableRow(props) {
  const [localFinancialAccount, setLocalFinancialAccount] = useState(props.financialAccount)
  const financialAccount = props.financialAccount
  const updateFinancialAccount = props.updateFinancialAccount

  return (
    <tr key={financialAccount.id}>
      <td>
        <input
          type="text"
          value={localFinancialAccount.name}
          onBlur={() => {
            updateFinancialAccount(localFinancialAccount)
          }}
          onChange={(event) => setLocalFinancialAccount({ ...localFinancialAccount, name: event.target.value })}
        />
      </td>
      <td>
        R¢
        <input
          type="number"
          value={localFinancialAccount.value}
          onBlur={() => {
            updateFinancialAccount(localFinancialAccount)
          }}
          onChange={(event) => setLocalFinancialAccount({ ...localFinancialAccount, value: event.target.value })}
        />
      </td>
      <td>{financialAccount.bankId.name}</td>
    </tr>
  )
}
