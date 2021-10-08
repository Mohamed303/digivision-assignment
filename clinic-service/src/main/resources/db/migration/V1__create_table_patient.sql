CREATE TABLE public.patient (
    patient_id BIGSERIAL ,
    patient_name character varying(256) ,
    patient_email character varying(256) ,
    patient_number character varying(256),
    status character varying(256),
    created_date TimeStamp null,
    updated_date TimeStamp null,
    appointments BIGSERIAL,

    CONSTRAINT patient_id_pmKey PRIMARY KEY (patient_id)

)
