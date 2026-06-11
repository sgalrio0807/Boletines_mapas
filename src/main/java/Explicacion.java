public class Explicacion {
    /*
===========================================================
        RESUMEN DEFINITIVO DE ESTRUCTURAS DE DATOS
===========================================================

Este archivo es SOLO de apoyo para el examen.
No forma parte del programa. Úsalo para recordar
qué estructura usar en cada caso.

===========================================================
                1. LISTAS (ArrayList)
===========================================================
✔ Permiten duplicados
✔ Mantienen el orden de inserción
✔ Acceso rápido por índice
✔ Ideales para recorrer y mostrar datos

USO TÍPICO:
- Lista de alumnos
- Lista de pedidos
- Lista de canciones
- Lista de objetos que pueden repetirse

EJEMPLO:
ArrayList<Actuacion> lista = new ArrayList<>();


===========================================================
                2. SETS (HashSet, TreeSet)
===========================================================
✔ NO permiten duplicados
✔ Búsqueda muy rápida (HashSet)
✔ TreeSet ordena automáticamente (requiere Comparable o Comparator)

USO TÍPICO:
- Conjunto de actuaciones sin repetir
- Usuarios únicos
- Productos únicos
- Objetos que NO deben duplicarse

EJEMPLO:
HashSet<Actuacion> conjunto = new HashSet<>();


===========================================================
                3. MAPAS (HashMap, TreeMap)
===========================================================
✔ Clave → Valor
✔ Acceso MUY rápido por clave
✔ Ideal para agrupar datos

USO TÍPICO:
- Escenario → Actuaciones
- Autor → Libros
- Cliente → Pedidos
- Curso → Alumnos

EJEMPLO:
HashMap<Escenario, HashSet<Actuacion>> mapa = new HashMap<>();


===========================================================
                4. ¿CUÁNDO USAR CADA ESTRUCTURA?
===========================================================

✔ QUIERO PERMITIR DUPLICADOS → ArrayList
✔ NO QUIERO DUPLICADOS → HashSet
✔ QUIERO BUSCAR POR CLAVE → HashMap
✔ QUIERO ORDEN AUTOMÁTICO → TreeSet / TreeMap
✔ QUIERO MANTENER ORDEN DE INSERCIÓN → LinkedHashSet / LinkedHashMap
✔ QUIERO AGRUPAR POR CATEGORÍA → Map<String, Integer>

RESUMEN RÁPIDO:
- LIST = duplicados
- SET = sin duplicados
- MAP = clave → valores
- TREE = orden automático
- HASH = rápido
- LINKED = mantiene orden


===========================================================
                5. COMPARABLE vs COMPARATOR
===========================================================

COMPARABLE (orden natural)
- Se implementa dentro de la clase
- Solo puede haber un orden natural

EJEMPLO:
public class Actuacion implements Comparable<Actuacion> {
    public int compareTo(Actuacion o) {
        return this.horaInicio.compareTo(o.horaInicio);
    }
}

COMPARATOR (orden alternativo)
- Se hace en una clase aparte
- Permite varios criterios de ordenación

EJEMPLO:
public class OrdenActuacion implements Comparator<Actuacion> {
    public int compare(Actuacion a1, Actuacion a2) {
        int res = Integer.compare(a2.getDuracionMinutos(), a1.getDuracionMinutos());
        if (res != 0) return res;
        return a1.getIdActuacion().compareTo(a2.getIdActuacion());
    }
}


===========================================================
                6. PATRONES TÍPICOS DE EXAMEN
===========================================================

1) Registrar clave en un mapa:
if (mapa.containsKey(clave)) throw new MiException("Ya existe");
mapa.put(clave, new HashSet<>());

2) Asignar elemento a una clave:
if (!mapa.containsKey(clave)) mapa.put(clave, new HashSet<>());
if (mapa.get(clave).contains(elemento)) throw new MiException("Duplicado");
mapa.get(clave).add(elemento);

3) Listar elementos ordenados:
List<Elemento> lista = new ArrayList<>(mapa.get(clave));
Collections.sort(lista, new ComparatorX());
return lista;

4) Agrupar por categoría:
Map<String, Integer> resultado = new HashMap<>();
for (Clave c : mapa.keySet()) {
    String categoria = c.getCategoria();
    int cantidad = mapa.get(c).size();
    resultado.put(categoria, resultado.getOrDefault(categoria, 0) + cantidad);
}

===========================================================
                7. REGLAS DE ORO PARA EL EXAMEN
===========================================================

✔ Si dudas entre List o Set → piensa: ¿puede repetirse?
✔ Si dudas entre Set o Map → piensa: ¿necesito clave?
✔ Si dudas entre Hash o Tree → piensa: ¿quiero orden automático?
✔ Si dudas entre Comparable o Comparator:
    - Orden natural → Comparable
    - Orden alternativo → Comparator

===========================================================
FIN DEL RESUMEN
===========================================================
*/

}
