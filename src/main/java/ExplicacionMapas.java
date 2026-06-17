public class ExplicacionMapas {
    /*
===========================================================
=        RESUMEN DEFINITIVO DE MAPAS (DAM – SERGIO)       =
===========================================================

──────────────────────────────────────────────────────────
1. ¿QUÉ ES UN MAPA?
──────────────────────────────────────────────────────────

Un MAPA almacena datos en forma de:

        CLAVE → VALOR

- La CLAVE es única (no se repite).
- El VALOR puede repetirse.
- Acceso muy rápido por clave.

Ejemplos típicos:
- códigoBatalla → Batalla
- DNI → Alumno
- matrícula → Coche
- códigoLibro → Libro
- nombreEquipo → Equipo

──────────────────────────────────────────────────────────
2. ¿CUÁNDO SE USA UN MAPA? (Regla definitiva)
──────────────────────────────────────────────────────────

Usa MAPA cuando el enunciado diga:

- “buscar por código”
- “identificador único”
- “clave → valor”
- “acceder rápidamente”
- “contar por categoría”
- “agrupar por clave”
- “no puede haber dos elementos con el mismo ID”

Si necesitas localizar algo por un identificador único → MAPA.

──────────────────────────────────────────────────────────
3. TIPOS DE MAPAS
──────────────────────────────────────────────────────────

3.1. HashMap (EL QUE SIEMPRE SE USA EN EXÁMENES)
- No tiene orden.
- Es el más rápido.
- Ideal para repositorios.

Ejemplo:
private HashMap<String, Batalla> batallas;

3.2. LinkedHashMap
- Mantiene el orden de inserción.
- Útil si quieres mostrar los elementos en el orden en que se añadieron.

3.3. TreeMap
- Ordena automáticamente por la CLAVE.
- La clave debe implementar Comparable.

──────────────────────────────────────────────────────────
4. OPERACIONES TÍPICAS DE UN MAPA
──────────────────────────────────────────────────────────

4.1. Insertar
mapa.put(clave, valor);

4.2. Buscar
mapa.get(clave);

4.3. Comprobar si existe
mapa.containsKey(clave);

4.4. Eliminar
mapa.remove(clave);

4.5. Recorrer claves
for (String clave : mapa.keySet()) { ... }

4.6. Recorrer valores
for (Objeto o : mapa.values()) { ... }

4.7. Recorrer clave + valor
for (String clave : mapa.keySet()) {
    Objeto o = mapa.get(clave);
}

──────────────────────────────────────────────────────────
5. MÉTODOS TÍPICOS QUE SIEMPRE CAEN EN EXÁMENES
──────────────────────────────────────────────────────────

===========================================================
5.1. Registrar elemento (con validación)
===========================================================

public void registrar(Artefacto a) throws MiExcepcion {
    if (inventario.containsKey(a.getCodigo())) {
        throw new MiExcepcion("Código duplicado");
    }
    inventario.put(a.getCodigo(), a);
}

===========================================================
5.2. Buscar por código
===========================================================

public Artefacto buscar(String codigo) {
    return inventario.get(codigo);
}

===========================================================
5.3. Actualizar elemento
===========================================================

public void actualizarStock(String codigo, int nuevo) throws MiExcepcion {
    Artefacto a = inventario.get(codigo);
    if (a == null) {
        throw new MiExcepcion("No existe");
    }
    a.setStock(nuevo);
}

===========================================================
5.4. Eliminar por clave
===========================================================

public void eliminar(String codigo) {
    inventario.remove(codigo);
}

===========================================================
5.5. Obtener todos como lista
===========================================================

public ArrayList<Artefacto> obtenerTodos() {
    return new ArrayList<>(inventario.values());
}

===========================================================
5.6. Contar por categoría (MAPA de Tipo → cantidad)
===========================================================

public HashMap<TipoArtefacto, Integer> contarPorTipo() {

    HashMap<TipoArtefacto, Integer> conteo = new HashMap<>();

    for (Artefacto a : inventario.values()) {

        TipoArtefacto tipo = a.getTipo();

        if (!conteo.containsKey(tipo)) {
            conteo.put(tipo, 1);
        } else {
            conteo.put(tipo, conteo.get(tipo) + 1);
        }
    }

    return conteo;
}

===========================================================
5.7. Obtener ordenados por precio (origen MAPA → LISTA)
===========================================================

public ArrayList<Artefacto> obtenerOrdenadosPorPrecio() {

    ArrayList<Artefacto> lista = new ArrayList<>(inventario.values());

    for (int i = 0; i < lista.size() - 1; i++) {
        for (int j = i + 1; j < lista.size(); j++) {

            Artefacto a = lista.get(i);
            Artefacto b = lista.get(j);

            if (a.getPrecio() > b.getPrecio()) {
                Artefacto aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
            }
        }
    }

    return lista;
}

──────────────────────────────────────────────────────────
6. EJEMPLOS REALES DE TODOS LOS TEMAS QUE HEMOS HECHO
──────────────────────────────────────────────────────────

6.1. BATALLAS (tu examen)
HashMap<String, Batalla> batallas;
- registrarBatalla()
- buscarBatalla()
- agregarComandante()
- actualizarBatalla()
- obtenerBatallasMenosSangrientas()

6.2. VIVERO (plantas)
HashMap<Integer, Planta> plantas;
- buscarPorCodigo()
- contarPorTipo()
- actualizarPrecio()

6.3. BIBLIOTECA
HashMap<String, Libro> libros;
- buscarLibro()
- contarPrestamosPorUsuario()
- actualizarLibro()

6.4. LIGA DE VIDEOJUEGOS
HashMap<String, Equipo> equipos;
- buscarEquipo()
- ordenarEquiposPorPuntos()
- actualizarEquipo()

6.5. GUARDERÍA
HashMap<String, Tutor> tutores;
- buscarTutor()
- contarNiñosPorTutor()

6.6. TIENDA
HashMap<String, Producto> productos;
- filtrarPorPrecio()
- actualizarStock()
- eliminarProducto()

──────────────────────────────────────────────────────────
7. FRASES CLAVE PARA EL EXAMEN
──────────────────────────────────────────────────────────

- “Un mapa se usa cuando necesito clave → valor.”
- “La clave es única, el valor puede repetirse.”
- “HashMap es el más rápido y el estándar.”
- “Para contar por categorías, siempre uso un HashMap.”
- “Para buscar por código, un mapa es la estructura ideal.”
- “Si quiero orden automático por clave, uso TreeMap.”
- “Si quiero mantener el orden de inserción, uso LinkedHashMap.”

===========================================================
FIN DEL RESUMEN
===========================================================
*/

}
