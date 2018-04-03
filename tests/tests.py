import requests
from pprint import pprint

host = 'http://localhost'
port = 8081
hostname = host + ':' + str(port) +'/'
airports_endpoint = hostname + 'airports'
distances_endpoint = hostname + 'distances'

miami_iata = 'MIA'
philadelphia_iata = 'PHL'

def print_header(header):
    print('***** ' + header)

def get_airports():
    print_header('GET /airports')
    get_airports = requests.get(airports_endpoint)
    pprint(get_airports.json())
    print('URL used: {}'.format(airports_endpoint))
    print('')
    
def get_airport(airport_identifier, iata):
    url = airports_endpoint + '/search/findByIata?iata={}'.format(iata)
    print_header('GET {} Airport'.format(airport_identifier))
    get_req = requests.get(url)
    pprint(get_req.json())
    print('URL used: {}'.format(url))
    print('')

def get_distance(src_iata, dest_iata):
    url = distances_endpoint + '?source={}&destination={}'.format(src_iata, dest_iata)
    print_header('Get distance from {} to {}'.format(src_iata, dest_iata))
    get_req = requests.get(url)
    pprint(get_req.json())
    print('URL used: {}'.format(url))
    print('')

# get airports
get_airports()

# get individual airports
get_airport('Miami', miami_iata)
get_airport('Philadelphia', philadelphia_iata)

# get distance
get_distance(miami_iata, philadelphia_iata)