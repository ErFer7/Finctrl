'''
Backend do Finctrl.
'''

from signal import SIGINT, SIGTERM
from gevent import signal_handler
from zerorpc import Server
from os import getcwd
from os.path import join

# pylint: disable=import-error
from source.managers.database_manager import DatabaseManager
from source.bank.controller.bank_controller import BankController

ADDRESS = 'tcp://127.0.0.1:1234'

database_manager = DatabaseManager(join(getcwd(), 'database', 'finctrl.sqlite'))

server = Server({
    'bank_api': BankController(database_manager)
})
server.bind(ADDRESS)

signal_handler(SIGTERM, server.stop)
signal_handler(SIGINT, server.stop)

server.run()
