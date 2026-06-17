public class Explicacion2 {
    /*
===========================================================
=   RESUMEN DEFINITIVO DE COLECCIONES Y ORDENACIÓN (DAM)  =
=   Hecho para examen – Sergio                           =
===========================================================

──────────────────────────────────────────────────────────
1. LISTA vs SET vs MAPA (Reglas definitivas)
──────────────────────────────────────────────────────────

LISTA (ArrayList)
- Permite repetidos.
- Tiene orden por índice.
- Ideal para: filtrar, ordenar, devolver varios elementos.
- Se usa cuando el enunciado dice:
    "puede repetirse"
    "varios elementos"
    "ordenar por..."
    "filtrar por..."
    "mostrar todos..."

SET (HashSet / TreeSet)
- NO permite repetidos.
- HashSet → sin orden.
- TreeSet → orden automático (usa compareTo).
- Se usa cuando el enunciado dice:
    "sin repetir"
    "únicos"
    "no duplicados"
    "conjunto de..."
    "ordenados automáticamente"

MAPA (HashMap)
- Estructura clave → valor.
- Búsqueda rápida por clave.
- Se usa cuando el enunciado dice:
    "buscar por código"
    "identificador único"
    "clave → valor"
    "contar por categoría"
    "agrupar por clave"

──────────────────────────────────────────────────────────
2. COMPARABLE vs COMPARATOR
──────────────────────────────────────────────────────────

Comparable (compareTo)
- Se implementa dentro de la clase.
- Define el ORDEN NATURAL del objeto.
- TreeSet y Collections.sort() lo usan automáticamente.
Ejemplo:
@Override
public int compareTo(Comandante otro) {
    int c = this.casa.compareTo(otro.casa);
    if (c != 0) return c;
    return this.nombre.compareTo(otro.nombre);
}

Comparator
- Se usa cuando el enunciado pide un orden distinto al natural.
- Se implementa en el repositorio.
Ejemplo:
Collections.sort(lista, new Comparator<Batalla>() {
    @Override
    public int compare(Batalla o1, Batalla o2) {
        return Integer.compare(o1.getBajas(), o2.getBajas());
    }
});

──────────────────────────────────────────────────────────
3. CÓMO DETECTAR QUÉ COLECCIÓN PIDE EL ENUNCIADO
──────────────────────────────────────────────────────────

LISTA → si dice:
- "varios"
- "puede repetirse"
- "ordenar por..."
- "filtrar por..."
- "mostrar todos"

SET → si dice:
- "sin repetir"
- "únicos"
- "no duplicados"
- "conjunto"

TREESET → si dice:
- "ordenados automáticamente"
- "orden natural"

MAPA → si dice:
- "buscar por código"
- "clave → valor"
- "identificador único"
- "contar por categoría"
- "agrupar por clave"

──────────────────────────────────────────────────────────
4. MÉTODOS TÍPICOS (TODOS LOS POSIBLES)
──────────────────────────────────────────────────────────

===========================================================
4.1. MÉTODOS DE AÑADIR
===========================================================

Añadir a LISTA:
lista.add(objeto);

Añadir a SET:
set.add(objeto);

Añadir a MAPA:
mapa.put(clave, objeto);

Añadir con validación:
public void agregar(Planta p) throws MiExcepcion {
    if (p == null) {
        throw new MiExcepcion("No puede ser null");
    }
    lista.add(p);
}

Añadir comandante a batalla:
public void agregarComandante(Comandante c) throws BatallaException {
    if (fecha.isBefore(LocalDate.now())) {
        throw new BatallaException("Batalla pasada");
    }
    comandantes.add(c);
}

===========================================================
4.2. MÉTODOS DE BÚSQUEDA
===========================================================

Buscar en LISTA:
public Objeto buscarPorNombre(String nombre) {
    Objeto encontrado = null;
    for (Objeto o : lista) {
        if (o.getNombre().equalsIgnoreCase(nombre)) {
            encontrado = o;
        }
    }
    return encontrado;
}

Buscar en SET:
public boolean existe(Objeto o) {
    return set.contains(o);
}

Buscar en MAPA:
public Objeto buscarPorCodigo(String codigo) {
    return mapa.get(codigo);
}

Buscar por fecha:
public ArrayList<Reserva> buscarPorFecha(LocalDate fecha) {
    ArrayList<Reserva> resultado = new ArrayList<>();
    for (Reserva r : reservas) {
        if (r.getFecha().equals(fecha)) {
            resultado.add(r);
        }
    }
    return resultado;
}

Buscar por rango de edad:
public ArrayList<Niño> buscarPorEdad(int min, int max) {
    ArrayList<Niño> res = new ArrayList<>();
    for (Niño n : niños) {
        if (n.getEdad() >= min && n.getEdad() <= max) {
            res.add(n);
        }
    }
    return res;
}

===========================================================
4.3. MÉTODOS DE FILTRADO
===========================================================

Filtrar por estado:
public ArrayList<Planta> filtrarPorEstado(Estado e) {
    ArrayList<Planta> res = new ArrayList<>();
    for (Planta p : plantas) {
        if (p.getEstado() == e) {
            res.add(p);
        }
    }
    return res;
}

Filtrar por tipo:
public ArrayList<Mascota> filtrarPorTipo(TipoMascota t) {
    ArrayList<Mascota> res = new ArrayList<>();
    for (Mascota m : mascotas) {
        if (m.getTipo() == t) {
            res.add(m);
        }
    }
    return res;
}

Filtrar por precio:
public ArrayList<Producto> filtrarPorPrecio(double min, double max) {
    ArrayList<Producto> res = new ArrayList<>();
    for (Producto p : productos) {
        if (p.getPrecio() >= min && p.getPrecio() <= max) {
            res.add(p);
        }
    }
    return res;
}

Filtrar por casa (Juego de Tronos):
public ArrayList<Comandante> filtrarPorCasa(Casa c) {
    ArrayList<Comandante> res = new ArrayList<>();
    for (Comandante com : comandantes) {
        if (com.getCasa() == c) {
            res.add(com);
        }
    }
    return res;
}

===========================================================
4.4. MÉTODOS DE ORDENACIÓN
===========================================================

Ordenar por nombre:
Collections.sort(lista, new Comparator<Objeto>() {
    @Override
    public int compare(Objeto o1, Objeto o2) {
        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
    }
});

Ordenar por fecha:
Collections.sort(lista, new Comparator<Reserva>() {
    @Override
    public int compare(Reserva r1, Reserva r2) {
        return r1.getFecha().compareTo(r2.getFecha());
    }
});

Ordenar por precio:
Collections.sort(lista, new Comparator<Producto>() {
    @Override
    public int compare(Producto p1, Producto p2) {
        return Double.compare(p1.getPrecio(), p2.getPrecio());
    }
});

Ordenar por puntuación:
Collections.sort(lista, new Comparator<Robot>() {
    @Override
    public int compare(Robot r1, Robot r2) {
        return r2.getPuntuacion() - r1.getPuntuacion();
    }
});

Ordenar por bajas (batallas):
Collections.sort(lista, new Comparator<Batalla>() {
    @Override
    public int compare(Batalla b1, Batalla b2) {
        return Integer.compare(b1.getBajas(), b2.getBajas());
    }
});

===========================================================
4.5. MÉTODOS DE CONTAR
===========================================================

Contar por tipo (MAPA):
public HashMap<Tipo, Integer> contarPorTipo() {
    HashMap<Tipo, Integer> conteo = new HashMap<>();
    for (Objeto o : lista) {
        Tipo t = o.getTipo();
        if (!conteo.containsKey(t)) {
            conteo.put(t, 1);
        } else {
            conteo.put(t, conteo.get(t) + 1);
        }
    }
    return conteo;
}

Contar activos:
public int contarActivos() {
    int total = 0;
    for (Objeto o : lista) {
        if (o.isActivo()) {
            total = total + 1;
        }
    }
    return total;
}

Contar reservas por cliente:
public int contarReservas(String cliente) {
    int total = 0;
    for (Reserva r : reservas) {
        if (r.getCliente().equalsIgnoreCase(cliente)) {
            total = total + 1;
        }
    }
    return total;
}

===========================================================
4.6. MÉTODOS DE ACTUALIZACIÓN
===========================================================

Actualizar en SET:
public void actualizar(Batalla nueva) {
    if (set.contains(nueva)) {
        set.remove(nueva);
    }
    set.add(nueva);
}

Actualizar en MAPA:
public void actualizar(String codigo, Objeto nuevo) {
    mapa.put(codigo, nuevo);
}

Actualizar precio:
public void actualizarPrecio(String codigo, double nuevo) {
    Producto p = mapa.get(codigo);
    if (p != null) {
        p.setPrecio(nuevo);
    }
}

===========================================================
4.7. MÉTODOS DE ELIMINAR
===========================================================

Eliminar de LISTA:
lista.remove(objeto);

Eliminar de SET:
set.remove(objeto);

Eliminar de MAPA:
mapa.remove(clave);

Eliminar por condición:
public void eliminarPorTipo(Tipo t) {
    ArrayList<Objeto> borrar = new ArrayList<>();
    for (Objeto o : lista) {
        if (o.getTipo() == t) {
            borrar.add(o);
        }
    }
    lista.removeAll(borrar);
}

===========================================================
4.8. MÉTODOS DE EXCEPCIONES
===========================================================

Lanzar excepción si no existe:
public Objeto buscar(String codigo) throws MiExcepcion {
    Objeto o = mapa.get(codigo);
    if (o == null) {
        throw new MiExcepcion("No existe");
    }
    return o;
}

Método con try-catch que devuelve boolean:
public boolean agregarSeguro(Repositorio repo, Objeto o) {
    boolean ok = false;
    try {
        repo.agregar(o);
        ok = true;
    } catch (MiExcepcion e) {
        ok = false;
    }
    return ok;
}

===========================================================
5. EJEMPLOS REALES DE TODOS LOS TEMAS
===========================================================

VIVERO:
- filtrarPorEstado()
- ordenarPorPrecio()
- contarPorTipo()

HOTEL:
- buscarHabitacion()
- ordenarReservasPorFecha()
- filtrarPorCategoria()

BIBLIOTECA:
- buscarLibro()
- ordenarLibrosPorTitulo()
- contarPrestamosPorUsuario()

BATALLAS:
- obtenerComandantesOrdenados()
- obtenerBatallasMenosSangrientas()
- agregarComandante()

ROBOTS:
- ordenarPorPuntuacion()
- filtrarPorTipo()
- actualizarRobot()

GUARDERÍA:
- filtrarPorEdad()
- ordenarPorNombre()
- contarPorTutor()

LIGA:
- ordenarEquiposPorPuntos()
- filtrarPartidasPorJugador()
- buscarEquipo()

TIENDA:
- filtrarPorPrecio()
- ordenarPorStock()
- contarPorCategoria()

===========================================================
FIN DEL RESUMEN
===========================================================
*/

}
