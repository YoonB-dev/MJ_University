hash_table = [0 for _ in range(100)]

def hash_function(key):
    return hash(key) % 100

def set_data(key, value):
    hash_value = hash_function(key)
    hash_table[hash_value] = value

def get_data(key):
    hash_value = hash_function(key)
    return hash_table[hash_value]

set_data('Rdav',2022)
set_data('hello',77)
print(get_data('Rdav'))
print(get_data('hello'))