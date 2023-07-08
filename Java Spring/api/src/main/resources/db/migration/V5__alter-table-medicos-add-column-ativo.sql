ALTER TABLE medicos ADD COLUMN ativo boolean DEFAULT true;

UPDATE medicos SET ativo = true;