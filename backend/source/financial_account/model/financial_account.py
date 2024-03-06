'''
Módulo da conta financeira.
'''

# pylint: disable=import-error
from source.bank.model.bank import Bank


class FinancialAccount():

    '''
    Conta financeira.
    '''

    _financial_account_id: int | None
    _bank: Bank
    _name: str
    _balance: int

    def __init__(self, bank: Bank, name: str, balance: int, financial_account_id: int | None = None) -> None:
        '''
        Inicializa a conta financeira.
        '''

        self._financial_account_id = financial_account_id
        self._bank = bank
        self._name = name
        self._balance = balance

    @property
    def financial_account_id(self) -> int | None:
        '''
        ID.
        '''

        return self._financial_account_id

    @property
    def bank(self) -> Bank:
        '''
        Banco.
        '''

        return self._bank

    @property
    def name(self) -> str:
        '''
        Nome.
        '''

        return self._name

    @property
    def balance(self) -> float:
        '''
        Saldo.
        '''

        return self._balance
