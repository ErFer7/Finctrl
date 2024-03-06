'''
Módulo do controller do banco.
'''

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager
from source.bank.service.bank_service import BankService


class BankController():

    '''
    Controlador do banco.
    '''

    _bank_service: BankService

    def __init__(self, database_manager: DatabaseManager) -> None:
        self._bank_service = BankService(database_manager)
