CREATE DATABASE IF NOT EXISTS `loinc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

DROP  TABLE IF EXISTS loinc.SourceOrganization;
CREATE TABLE loinc.SourceOrganization (
  copyright_id varchar(255) not null,
  name varchar(255) default null,
  copyright text,
  terms_of_use text,
  url text default null,
  primary key (copyright_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS loinc.Loinc;
CREATE TABLE loinc.Loinc (
  loinc_num varchar(10) not null,
  component varchar(255) default null,
  property varchar(255) default null,
  time_aspct varchar(255) default null,
  syst varchar(255) default null,
  scale_typ varchar(255) default null,
  method_typ varchar(255) default null,
  class varchar(255) default null,
  VersionLastChanged varchar(255) default null,
  chng_type varchar(255) default null,
  DefinitionDescription text,
  status varchar(255) default null,
  consumer_name varchar(255) default null,
  classtype int(11) default null,
  formula text,
  species varchar(20) default null,
  exmpl_answers text,
  survey_quest_text text,
  survey_quest_src varchar(50) default null,
  unitsrequired varchar(1) default null,
  submitted_units varchar(30) default null,
  relatednames2 text,
  shortname varchar(255) default null,
  order_obs varchar(15) default null,
  cdisc_common_tests varchar(1) default null,
  hl7_field_subfield_id varchar(50) default null,
  external_copyright_notice text,
  example_units varchar(255) default null,
  long_common_name varchar(255) default null,
  UnitsAndRange text,
  document_section varchar(255) default null,
  example_ucum_units varchar(255) default null,
  example_si_ucum_units varchar(255) default null,
  status_reason varchar(9) default null,
  status_text text,
  change_reason_public text,
  common_test_rank integer default null,
  common_order_rank integer default null,
  common_si_test_rank integer default null,
  hl7_attachment_structure varchar(15) default null,
  ExternalCopyrightLink varchar(255) default null,
  PanelType varchar(50) default null,
  AskAtOrderEntry varchar(255) default null,
  AssociatedObservations varchar(255) default null,
  VersionFirstReleased varchar(255) default null,
  ValidHL7AttachmentRequest varchar(50) default null,

  primary key (loinc_num)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS loinc.MapTo;
CREATE TABLE loinc.MapTo (
  loinc varchar(10) NOT NULL,
  map_to varchar(10) NOT NULL,
  comment text,
  primary key (loinc, map_to)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


