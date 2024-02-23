'''
Módulo do controller do banco.
'''

# Infelizmente, o pylint não consegue reconhecer a importação de módulos
# pylint: disable=import-error

from source.bank.service.bank_service import BankService


class BankController():

    '''
    Controlador do banco.
    '''

    _bank_service: BankService

    def __init__(self) -> None:
        self._bank_service = BankService()
