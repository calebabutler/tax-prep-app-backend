import numpy as np

states = ['AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'DC', 'FL', 'GA',
          'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA',
          'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY',
          'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX',
          'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY']

filings = ['single', 'jointly', 'separately']

def create_profile(state):
    print(f"insert into PROFILES (state) values ('{state}');")


def create_finance_info(filing, income):
    int_income = int(income * 100)
    print(f"insert into FINANCES (filing_status, w2_income) values ('{filing}', {int_income});")


def main():
    # Create profiles
    for i in range(100):
        create_profile(states[np.random.randint(0, len(states))])
    # Create finance info
    for i in range(100):
        create_finance_info(filings[np.random.randint(0, len(filings))], np.random.normal(50000, 10000))


if __name__ == '__main__':
    main()