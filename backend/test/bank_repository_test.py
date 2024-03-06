'''
Testes para o repositório de banco.
'''

from os.path import join
from pytest import fixture

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager
from source.bank.model.bank import Bank
from source.bank.repository.bank_repository import BankRepository


@fixture(scope='module')
def database_manager():
    '''
    Fixture para o gerenciador de banco de dados
    '''

    return DatabaseManager(join('test', 'test.sqlite'))


@fixture(autouse=True)
def clean_database(database_manager: DatabaseManager):
    '''
    Fixture to clean the database before each test.
    '''
    cursor = database_manager.get_new_cursor()
    cursor.execute('DELETE FROM bank;')
    database_manager.commit()


@fixture(scope='module')
def bank_repository(database_manager: DatabaseManager):
    '''
    Fixture para o repositório de banco
    '''

    return BankRepository(database_manager)


def test_add_bank(database_manager: DatabaseManager, bank_repository: BankRepository):
    '''
    Teste para adicionar um banco.
    '''

    bank = Bank('Banco do Brasil')

    bank_repository.add_bank(bank)

    cursor = database_manager.get_new_cursor()
    cursor.execute('SELECT name FROM bank WHERE id = 1;')
    assert cursor.fetchone()[0] == 'Banco do Brasil'


def test_get_bank(database_manager: DatabaseManager, bank_repository: BankRepository):
    '''
    Teste para obter um banco.
    '''

    cursor = database_manager.get_new_cursor()
    cursor.executescript('INSERT INTO bank (name) VALUES ("Banco do Brasil");')

    bank = bank_repository.get_bank(1)

    assert bank.name == 'Banco do Brasil'
    assert bank.bank_id == 1


def test_get_banks(database_manager: DatabaseManager, bank_repository: BankRepository):
    '''
    Teste para obter os bancos.
    '''

    cursor = database_manager.get_new_cursor()
    cursor.executescript('INSERT INTO bank (name) VALUES ("Banco do Brasil");')
    cursor.executescript('INSERT INTO bank (name) VALUES ("Itaú");')

    banks = bank_repository.get_banks()

    assert len(banks) == 2
    assert banks[0].name == 'Banco do Brasil'
    assert banks[0].bank_id == 1
    assert banks[1].name == 'Itaú'
    assert banks[1].bank_id == 2

def test_update_bank(database_manager: DatabaseManager, bank_repository: BankRepository):
    '''
    Teste para atualizar um banco.
    '''

    cursor = database_manager.get_new_cursor()
    cursor.executescript('INSERT INTO bank (name) VALUES ("Banco do Brasil");')

    bank = Bank('Itaú', 1)
    bank_repository.update_bank(bank)

    cursor.execute('SELECT name FROM bank WHERE id = 1;')
    assert cursor.fetchone()[0] == 'Itaú'

def test_delete_bank(database_manager: DatabaseManager, bank_repository: BankRepository):
    '''
    Teste para deletar um banco.
    '''

    cursor = database_manager.get_new_cursor()
    cursor.executescript('INSERT INTO bank (name) VALUES ("Banco do Brasil");')

    bank_repository.delete_bank(1)

    cursor.execute('SELECT name FROM bank WHERE id = 1;')
    assert cursor.fetchone() is None

