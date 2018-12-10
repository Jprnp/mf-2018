CREATE USER sqluser IDENTIFIED BY 'sqluser';

grant usage on *.* to 'sqluser';
grant all privileges on loinc.* to 'sqluser';