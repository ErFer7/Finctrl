'''
Módulo de repositório.
'''

from sqlite3 import Cursor

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager


class Repository():

    '''
    Repositório.
    '''

    _database_manager: DatabaseManager
    _cursor: Cursor

    def __init__(self, database_manager: DatabaseManager) -> None:
        self._database_manager = database_manager
        self._cursor = self._database_manager.get_new_cursor()

    @property
    def database_manager(self) -> DatabaseManager:
        '''
        Gerenciador de banco de dados.
        '''

        return self._database_manager

    @property
    def cursor(self) -> Cursor:
        '''
        Cursor.
        '''

        return self._cursor
