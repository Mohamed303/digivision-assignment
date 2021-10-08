ALTER TABLE  public.patient
ADD CONSTRAINT patient_appointment_fkey foreign key(appointments) references public.appointments;

ALTER TABLE public.appointments
ADD CONSTRAINT appointment_patient_fkey foreign key(patient_id) references public.patient;


