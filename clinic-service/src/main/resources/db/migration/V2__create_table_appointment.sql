CREATE TABLE public.appointments(
    appointment_id BIGSERIAL ,
    appointment_date TimeStamp null ,
    created_date TimeStamp null,
    updated_date TimeStamp null,
    cancel_notice character varying(256),
    patient_id BIGSERIAL,

    CONSTRAINT appointment_id_pmKey PRIMARY KEY (appointment_id)

)
