'''
Backend do Finctrl.
'''

from signal import SIGINT, SIGTERM
from gevent import signal_handler
from zerorpc import Server

from source.bank.controller.bank_controller import BankController

ADDRESS = 'tcp://127.0.0.1:1234'

server = Server({
    'bank_api': BankController()
})
server.bind(ADDRESS)

signal_handler(SIGTERM, server.stop)
signal_handler(SIGINT, server.stop)

server.run()
