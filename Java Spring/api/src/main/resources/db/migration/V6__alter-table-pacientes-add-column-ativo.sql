ALTER TABLE pacientes ADD COLUMN ativo boolean DEFAULT true;

UPDATE pacientes SET ativo = true;