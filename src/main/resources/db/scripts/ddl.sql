USE sgq-quality-compliance;

CREATE TABLE departament (
  id_departament BIGINT NOT NULL,
   des_departament VARCHAR(255) NULL,
   des_location VARCHAR(255) NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_departament PRIMARY KEY (id_departament)
);

CREATE TABLE non_compliance (
  id_non_compliance BIGINT NOT NULL,
   des_non_compliance VARCHAR(255) NULL,
   des_operational_consequence VARCHAR(255) NULL,
   des_type VARCHAR(255) NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_non_compliance PRIMARY KEY (id_non_compliance)
);

CREATE TABLE part (
  id_part BIGINT NOT NULL,
   des_name VARCHAR(255) NULL,
   des_model VARCHAR(255) NULL,
   num_serial_number BIGINT NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_part PRIMARY KEY (id_part)
);

CREATE TABLE vehicle (
  id_vehicle BIGINT NOT NULL,
   des_name VARCHAR(255) NULL,
   des_model VARCHAR(255) NULL,
   dt_release datetime NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_vehicle PRIMARY KEY (id_vehicle)
);

CREATE TABLE role (
  id_role BIGINT NOT NULL,
   des_name VARCHAR(255) NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_role PRIMARY KEY (id_role)
);

CREATE TABLE profile (
  id_profile BIGINT NOT NULL,
   des_profile VARCHAR(255) NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_profile PRIMARY KEY (id_profile)
);

CREATE TABLE user (
  id_user BIGINT NOT NULL,
   des_name VARCHAR(255) NULL,
   des_email VARCHAR(255) NULL,
   des_document VARCHAR(255) NULL,
   des_phone VARCHAR(255) NULL,
   des_genre VARCHAR(255) NULL,
   id_role BIGINT NULL,
   id_departament BIGINT NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_user PRIMARY KEY (id_user)
);

ALTER TABLE user ADD CONSTRAINT fk_user_on_id_departament FOREIGN KEY (id_departament) REFERENCES departament (id_departament);

ALTER TABLE user ADD CONSTRAINT fk_user_on_id_role FOREIGN KEY (id_role) REFERENCES `role` (id_role);

CREATE TABLE user_profile (
  id_profile BIGINT NOT NULL,
   id_user BIGINT not null,
   CONSTRAINT pk_user_profile PRIMARY KEY (id_profile, id_user)
);

ALTER TABLE user_profile ADD CONSTRAINT fk_usepro_on_profile_entity FOREIGN KEY (id_profile) REFERENCES profile (id_profile);

ALTER TABLE user_profile ADD CONSTRAINT fk_usepro_on_user_entity FOREIGN KEY (id_user) REFERENCES user (id_user);

CREATE TABLE non_compliance_action (
  id_non_compliance_action BIGINT NOT NULL,
   des_immediate_action VARCHAR(255) NULL,
   des_follow_up_action VARCHAR(255) NULL,
   dt_due_date datetime NULL,
   id_non_compliance BIGINT NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_non_compliance_action PRIMARY KEY (id_non_compliance_action)
);

ALTER TABLE non_compliance_action ADD CONSTRAINT fk_non_compliance_action_on_id_non_compliance FOREIGN KEY (id_non_compliance) REFERENCES non_compliance (id_non_compliance);

CREATE TABLE incident (
  id_incident BIGINT NOT NULL,
   des_incident VARCHAR(255) NULL,
   des_status VARCHAR(255) NULL,
   des_type VARCHAR(255) NULL,
   des_place VARCHAR(255) NULL,
   des_demage VARCHAR(255) NULL,
   id_part BIGINT NULL,
   id_vehicle BIGINT NULL,
   id_non_compliance BIGINT NULL,
   id_user BIGINT NULL,
   dt_creation datetime NOT NULL,
   dt_update datetime NULL,
   CONSTRAINT pk_incident PRIMARY KEY (id_incident)
);

ALTER TABLE incident ADD CONSTRAINT fk_incident_on_id_non_compliance FOREIGN KEY (id_non_compliance) REFERENCES non_compliance (id_non_compliance);

ALTER TABLE incident ADD CONSTRAINT fk_incident_on_id_part FOREIGN KEY (id_part) REFERENCES part (id_part);

ALTER TABLE incident ADD CONSTRAINT fk_incident_on_id_user FOREIGN KEY (id_user) REFERENCES user (id_user);

ALTER TABLE incident ADD CONSTRAINT fk_incident_on_id_vehicle FOREIGN KEY (id_vehicle) REFERENCES vehicle (id_vehicle);