-- Script de inicialización de la base de datos
-- Este archivo se ejecuta automáticamente al iniciar PostgreSQL

-- Insertar Estados
INSERT INTO estado (id_estado, nombre) VALUES (1, 'Pendiente') ON CONFLICT DO NOTHING;
INSERT INTO estado (id_estado, nombre) VALUES (2, 'En Progreso') ON CONFLICT DO NOTHING;
INSERT INTO estado (id_estado, nombre) VALUES (3, 'Completada') ON CONFLICT DO NOTHING;

-- Insertar Categorías
INSERT INTO categoria (id_categoria, nombre, color) VALUES (1, 'Trabajo', '#FF0000') ON CONFLICT DO NOTHING;
INSERT INTO categoria (id_categoria, nombre, color) VALUES (2, 'Personal', '#00FF00') ON CONFLICT DO NOTHING;
INSERT INTO categoria (id_categoria, nombre, color) VALUES (3, 'Urgente', '#FFFF00') ON CONFLICT DO NOTHING;
INSERT INTO categoria (id_categoria, nombre, color) VALUES (4, 'Educación', '#0000FF') ON CONFLICT DO NOTHING;
