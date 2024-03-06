'''
Repositório da conta financeira.
'''

# pylint: disable=import-error
from source.base.repository import Repository
from source.financial_account.model.financial_account import FinancialAccount


class FinancialAccountRepository(Repository):

    '''
    Repositório da conta financeira.
    '''

    def add_financial_account(self, financial_account: FinancialAccount) -> None:
        '''
        Adiciona uma conta financeira.
        '''

        self.cursor.executescript(
            'INSERT INTO financial_account (bank_id, name, balance) VALUES ' +
            f'({financial_account.bank.bank_id}, "{financial_account.name}", {financial_account.balance});')
        self.database_manager.commit()
