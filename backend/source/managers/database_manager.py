'''
Módulo responsável por gerenciar a conexão com o banco de dados.
'''

from sqlite3 import connect, Cursor, Connection

class DatabaseManager():

    '''
    Classe responsável por gerenciar a conexão com o banco de dados.
    '''

    _connection: Connection | None

    def __init__(self, database_path: str) -> None:
        '''
        Inicializa o gerenciador.
        '''

        self._connection = connect(database_path)

    def __del__(self) -> None:
        '''
        Finaliza o gerenciador.
        '''

        if self._connection is not None:
            self._connection.close()

    def get_new_cursor(self) -> Cursor:
        '''
        Retorna um novo cursor.
        '''

        if self._connection is None:
            raise ConnectionError('Database connection is closed.')

        return self._connection.cursor()

    def commit(self) -> None:
        '''
        Realiza o commit das alterações no banco de dados.
        '''

        if self._connection is None:
            raise ConnectionError('Database connection is closed.')

        self._connection.commit()
