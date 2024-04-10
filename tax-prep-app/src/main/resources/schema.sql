drop table if exists FINANCES;
drop table if exists PROFILES;

create table PROFILES(
  id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50),
	middle_initial VARCHAR(1),
	last_name VARCHAR(50),
  date_of_birth INT,
  address VARCHAR(50),
  city VARCHAR(50),
  state VARCHAR(2),
  apt_number INT,
  zip_code INT,
  ssn INT
);

create table FINANCES(
  id INT AUTO_INCREMENT PRIMARY KEY,
  filing_status VARCHAR(50),
	spouse_first_name VARCHAR(50),
	spouse_middle_initial VARCHAR(1),
	spouse_last_name VARCHAR(50),
  spouse_ssn INT,
  w2_income INT,
  other_income INT,
  tax_withheld_w2 INT,
  tax_withheld_1099 INT,
  tax_withheld_other INT,
  prev_taxes_paid INT,
  profile_id INT,
  FOREIGN KEY (profile_id) REFERENCES PROFILES(id)
);
