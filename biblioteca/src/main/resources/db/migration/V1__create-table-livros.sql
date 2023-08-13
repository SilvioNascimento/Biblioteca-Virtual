CREATE TABLE livros(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    titulo TEXT NOT NULL,
    autor TEXT NOT NULL,
    tipo_textual TEXT NOT NULL,
    ano_publicacao INTEGER NOT NULL,
    capa_do_livro TEXT
);

GRANT ALL ON SCHEMA public TO silvio