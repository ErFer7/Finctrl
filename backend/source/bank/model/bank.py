'''
Banco.
'''


class Bank():

    '''
    Bank.
    '''

    _bank_id: int | None
    _name: str

    def __init__(self, name: str, bank_id: int | None = None) -> None:
        self._bank_id = bank_id
        self._name = name

    @property
    def bank_id(self) -> int | None:
        '''
        Id.
        '''

        return self._bank_id

    @property
    def name(self) -> str:
        '''
        Nome.
        '''

        return self._name

    @name.setter
    def name(self, name: str) -> None:
        '''
        Nome.
        '''

        self._name = name
