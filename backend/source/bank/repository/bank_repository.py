'''
Repositório do banco.
'''

# pylint: disable=import-error
from source.base.repository import Repository
from source.bank.model.bank import Bank


class BankRepository(Repository):

    '''
    Repositório do banco.
    '''

    def add_bank(self, bank: Bank) -> None:
        '''
        Adiciona um banco.
        '''

        self.cursor.executescript(f'INSERT INTO bank (name) VALUES ("{bank.name}");')
        self.database_manager.commit()

    def get_bank(self, bank_id: int) -> Bank:
        '''
        Obtém um banco.
        '''

        self.cursor.execute(f'SELECT name FROM bank WHERE id = {bank_id};')
        bank = self.cursor.fetchone()

        return Bank(bank[0], bank_id)

    def get_banks(self) -> list[Bank]:
        '''
        Obtém os bancos.
        '''

        self.cursor.execute('SELECT id, name FROM bank;')
        banks = self.cursor.fetchall()

        return [Bank(bank[1], bank[0]) for bank in banks]

    def update_bank(self, bank: Bank) -> None:
        '''
        Atualiza um banco.
        '''

        self.cursor.executescript(f'UPDATE bank SET name = "{bank.name}" WHERE id = {bank.bank_id};')
        self.database_manager.commit()

    def delete_bank(self, bank_id: int) -> None:
        '''
        Deleta um banco.
        '''

        self.cursor.executescript(f'DELETE FROM bank WHERE id = {bank_id};')
        self.database_manager.commit()
