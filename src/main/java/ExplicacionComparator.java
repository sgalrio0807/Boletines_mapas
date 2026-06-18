public class ExplicacionComparator {
    /*
===========================================================
                COMPARABLE vs COMPARATOR
===========================================================

===========================
1. COMPARABLE (compareTo)
===========================
- Se escribe DENTRO de la clase.
- Solo puede haber UN criterio de orden.
- Define el "orden natural" del objeto.
- Se usa cuando:
    * El enunciado dice "orden natural" o "orden por defecto".
    * Usas TreeSet o TreeMap (lo exige).
    * Siempre quieres ordenar por lo mismo (id, dorsal, nombre...).

Ejemplo 1: ordenar pilotos por dorsal (orden natural)
-----------------------------------------------------
public class Piloto implements Comparable<Piloto> {
    @Override
    public int compareTo(Piloto otro) {
        return this.dorsal - otro.dorsal; // menor a mayor
    }
}

Ejemplo 2: ordenar experimentos por id
--------------------------------------
public int compareTo(Experimento e) {
    return this.id.compareToIgnoreCase(e.id);
}

Ejemplo 3: ordenar escuderías por nombre
----------------------------------------
public int compareTo(Escuderia e) {
    return this.nombre.compareToIgnoreCase(e.nombre);
}

===========================================================

===========================
2. COMPARATOR (compare)
===========================
- Se escribe FUERA de la clase.
- Puedes crear TODOS los criterios que quieras.
- Sirve para ordenaciones alternativas.
- Se usa cuando:
    * El enunciado pide "ordenar por otro criterio".
    * Ordenar por varios criterios.
    * Ordenar de MAYOR a MENOR.
    * Ordenar listas que vienen de un mapa.

Ejemplo 1: ordenar pilotos por puntos (mayor a menor)
-----------------------------------------------------
if (p1.getPuntos() < p2.getPuntos()) return 1;
if (p1.getPuntos() > p2.getPuntos()) return -1;
return 0;

Ejemplo 2: ordenar experimentos por duración y si empatan por id
-----------------------------------------------------------------
if (e1.getHoras() < e2.getHoras()) return 1;
if (e1.getHoras() > e2.getHoras()) return -1;
return e1.getId().compareToIgnoreCase(e2.getId());

Ejemplo 3: ordenar escuderías por trofeos
-----------------------------------------
if (e1.getTrofeos() > e2.getTrofeos()) return -1;
if (e1.getTrofeos() < e2.getTrofeos()) return 1;
return 0;

===========================================================

===========================
3. SEGÚN LA ESTRUCTURA
===========================

LIST (ArrayList)
----------------
✔ Acepta Comparable
✔ Acepta Comparator
✔ Puedes ordenar como quieras

Regla:
- Orden fijo → Comparable
- Orden puntual → Comparator

-----------------------------------------------------------

SET
----------------
HashSet / LinkedHashSet:
❌ NO ordenan → NO usan Comparable ni Comparator

TreeSet:
✔ Necesita Comparable o Comparator
✔ Si no lo tiene → ERROR

-----------------------------------------------------------

MAP
----------------
HashMap / LinkedHashMap:
❌ NO ordenan → NO usan Comparable ni Comparator

TreeMap:
✔ Ordena por la CLAVE
✔ La clave necesita Comparable o Comparator

Ejemplo:
TreeMap<Escuderia, List<Piloto>> mapa = new TreeMap<>();
→ Escuderia debe tener compareTo()

===========================================================

===========================
4. REGLAS EXPRESS (EXAMEN)
===========================
- Orden natural → Comparable
- Orden por otro criterio → Comparator
- Mayor a menor → Comparator
- Varios criterios → Comparator
- TreeSet / TreeMap → Comparable o Comparator
- HashSet / HashMap → NO ordenan
- Orden fijo → Comparable
- Orden puntual → Comparator

===========================================================
*/

}
