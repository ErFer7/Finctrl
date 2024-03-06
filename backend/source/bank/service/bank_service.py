'''
Módulo de serviço do banco.
'''

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager
from source.bank.repository.bank_repository import BankRepository

class BankService():

    '''
    Serviço do banco.
    '''

    _bank_repository: BankRepository

    def __init__(self, database_manager: DatabaseManager) -> None:
        self._bank_repository = BankRepository(database_manager)
