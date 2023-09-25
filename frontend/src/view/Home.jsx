import FinancialAccountsTable from '../components/FinancialAccountsTable';
import '../styles/default.css';
import '../styles/utilities.css';

export default function Home() {
  return (
    <>
      <div className='container'>
        <h1 className='center'>Finctrl</h1>
        <hr />
        <p>
          Sitema de controle financeiro pessoal
        </p>
        <div className='row'>
          <FinancialAccountsTable />
        </div>
      </div>
    </>
  );
}
