public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int paginas;
    private int anioPublicacion;
    private int idLibro;
    private static int id = 0;

    public Libro(String titulo, String autor, String isbn, String editorial, int paginas, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
        this.anioPublicacion = anioPublicacion;
        this.idLibro = ++id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Libro.id = id;
    }

    @Override
    public String toString() {
        return "ID: "  + idLibro +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nPaginas: " + paginas +
                "\nEditorial: " + editorial +
                "\nISBN: " + isbn +
                "\nAño Publicación: " + anioPublicacion;
    }
}
