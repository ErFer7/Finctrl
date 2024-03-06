'''
Repositório do banco.
'''

from sqlite3 import Cursor

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager
from source.bank.model.bank import Bank

class BankRepository:

    '''
    Repositório do banco.
    '''

    _database_manager: DatabaseManager
    _cursor: Cursor

    def __init__(self, database_manager: DatabaseManager) -> None:
        self._database_manager = database_manager
        self._cursor = self._database_manager.get_new_cursor()

    def add_bank(self, bank: Bank) -> None:
        '''
        Adiciona um banco.
        '''

        self._cursor.executescript(f'INSERT INTO bank (name) VALUES ("{bank.name}");')
        self._database_manager.commit()

    def get_bank(self, bank_id: int) -> Bank:
        '''
        Obtém um banco.
        '''

        self._cursor.execute(f'SELECT name FROM bank WHERE id = {bank_id};')
        bank = self._cursor.fetchone()

        return Bank(bank[0], bank_id)

    def get_banks(self) -> list[Bank]:
        '''
        Obtém os bancos.
        '''

        self._cursor.execute('SELECT id, name FROM bank;')
        banks = self._cursor.fetchall()

        return [Bank(bank[1], bank[0]) for bank in banks]

    def update_bank(self, bank: Bank) -> None:
        '''
        Atualiza um banco.
        '''

        self._cursor.executescript(f'UPDATE bank SET name = "{bank.name}" WHERE id = {bank.bank_id};')
        self._database_manager.commit()

    def delete_bank(self, bank_id: int) -> None:
        '''
        Deleta um banco.
        '''

        self._cursor.executescript(f'DELETE FROM bank WHERE id = {bank_id};')
        self._database_manager.commit()
