'''
Migra o banco de dados para a versão mais recente.
'''

from sqlite3 import connect
from os.path import join, exists
from os import listdir


def migrate() -> None:
    '''
    Migra o banco.
    '''

    with connect('finctrl.sqlite') as database:
        cursor = database.cursor()
        cursor.execute('PRAGMA user_version;')
        current_version = cursor.fetchone()[0]

        print(f'Current database version: {current_version}')

        migrations = listdir('migrations')
        migrations = map(lambda migration: int(migration[1:]), migrations)
        migrations = list(filter(lambda migration: migration > current_version, migrations))
        migrations.sort()

        if len(migrations) == 0:
            print('Database is already up to date.')
        else:
            for migration in migrations:
                print(f'Applying migration {migration}...')

                schema_file = join('migrations', f'v{migration}', 'schema.sql')
                data_file = join('migrations', f'v{migration}', 'data.sql')
                last_file = join('migrations', f'v{migration}', 'last.sql')

                if exists(schema_file):
                    with open(schema_file, 'r', encoding='utf-8') as file:
                        cursor.executescript(file.read())

                if exists(data_file):
                    with open(data_file, 'r', encoding='utf-8') as file:
                        cursor.executescript(file.read())

                if exists(last_file):
                    with open(last_file, 'r', encoding='utf-8') as file:
                        cursor.executescript(file.read())

                cursor.execute(f'PRAGMA user_version = {migration};')
                print(f'Migration {migration} applied.')

            print(f'Database updated successfully to version {migrations[-1]}')


if __name__ == '__main__':
    migrate()
