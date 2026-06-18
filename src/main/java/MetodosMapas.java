import java.util.*;

public class MetodosMapas {

    private HashMap<String, String> mapa;
    private HashMap<String, Integer> mapaContador;
    private HashMap<String, ArrayList<String>> mapaListas;

    public MetodosMapas() {
        this.mapa = mapa;
        this.mapaContador = mapaContador;
        this.mapaListas = mapaListas;
    }

    // ============================================================
    // 1. INSERTAR (put)
    // ============================================================
    public void insertar(String clave, String valor) {
        // Inserta o reemplaza el valor asociado a la clave
        mapa.put(clave, valor);
    }

    // ============================================================
    // 2. INSERTAR SOLO SI NO EXISTE (putIfAbsent)
    // ============================================================
    public void insertarSiNoExiste(String clave, String valor) {
        // Solo inserta si la clave no está registrada
        mapa.putIfAbsent(clave, valor);
    }

    // ============================================================
    // 3. BUSCAR (get)
    // ============================================================
    public String buscar(String clave) {
        // Devuelve el valor o null si no existe
        String resultado = mapa.get(clave);
        return resultado;
    }

    // ============================================================
    // 4. BUSCAR CON VALOR POR DEFECTO (getOrDefault)
    // ============================================================
    public String buscarConDefecto(String clave, String defecto) {
        // Si no existe la clave, devuelve el valor por defecto
        String resultado = mapa.getOrDefault(clave, defecto);
        return resultado;
    }

    // ============================================================
    // 5. COMPROBAR SI EXISTE UNA CLAVE (containsKey)
    // ============================================================
    public boolean existeClave(String clave) {
        boolean existe = mapa.containsKey(clave);
        return existe;
    }

    // ============================================================
    // 6. COMPROBAR SI EXISTE UN VALOR (containsValue)
    // ============================================================
    public boolean existeValor(String valor) {
        boolean existe = mapa.containsValue(valor);
        return existe;
    }

    // ============================================================
    // 7. ELIMINAR (remove)
    // ============================================================
    public void eliminar(String clave) {
        mapa.remove(clave);
    }

    // ============================================================
    // 8. REEMPLAZAR VALOR (replace)
    // ============================================================
    public void reemplazar(String clave, String nuevoValor) {
        mapa.replace(clave, nuevoValor);
    }

    // ============================================================
    // 9. REEMPLAZAR SOLO SI COINCIDE EL VALOR ACTUAL
    // ============================================================
    public void reemplazarSeguro(String clave, String valorViejo, String valorNuevo) {
        mapa.replace(clave, valorViejo, valorNuevo);
    }

    // ============================================================
    // 10. OBTENER TODAS LAS CLAVES (keySet)
    // ============================================================
    public ArrayList<String> obtenerClaves() {
        ArrayList<String> resultado = new ArrayList<>(mapa.keySet());
        return resultado;
    }

    // ============================================================
    // 11. OBTENER TODOS LOS VALORES (values)
    // ============================================================
    public ArrayList<String> obtenerValores() {
        ArrayList<String> resultado = new ArrayList<>(mapa.values());
        return resultado;
    }

    // ============================================================
    // 12. OBTENER PARES CLAVE → VALOR (entrySet)
    // ============================================================
    public ArrayList<String> obtenerPares() {
        ArrayList<String> resultado = new ArrayList<>();

        for (Map.Entry<String, String> entrada : mapa.entrySet()) {
            resultado.add(entrada.getKey() + " → " + entrada.getValue());
        }

        return resultado;
    }

    // ============================================================
    // 13. LIMPIAR MAPA (clear)
    // ============================================================
    public void limpiar() {
        mapa.clear();
    }

    // ============================================================
    // 14. COMPROBAR SI ESTÁ VACÍO (isEmpty)
    // ============================================================
    public boolean estaVacio() {
        boolean vacio = mapa.isEmpty();
        return vacio;
    }

    // ============================================================
    // 15. OBTENER TAMAÑO (size)
    // ============================================================
    public int tamaño() {
        int tamaño = mapa.size();
        return tamaño;
    }

    // ============================================================
    // 16. CONTAR POR CATEGORÍA (clave → contador)
    // ============================================================
    public void contar(String categoria) {
        int actual = mapaContador.getOrDefault(categoria, 0);
        mapaContador.put(categoria, actual + 1);
    }

    // ============================================================
    // 17. AGRUPAR ELEMENTOS EN LISTAS (clave → lista)
    // ============================================================
    public void agrupar(String clave, String elemento) {
        mapaListas.putIfAbsent(clave, new ArrayList<>());
        mapaListas.get(clave).add(elemento);
    }

    // ============================================================
    // 18. OBTENER LISTA ASOCIADA A UNA CLAVE
    // ============================================================
    public ArrayList<String> obtenerLista(String clave) {
        ArrayList<String> resultado = mapaListas.getOrDefault(clave, new ArrayList<>());
        return resultado;
    }

    // ============================================================
    // 19. ORDENAR LISTA DENTRO DEL MAPA
    // ============================================================
    public ArrayList<String> obtenerListaOrdenada(String clave) {
        ArrayList<String> resultado = new ArrayList<>(mapaListas.getOrDefault(clave, new ArrayList<>()));

        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = i + 1; j < resultado.size(); j++) {
                String a = resultado.get(i);
                String b = resultado.get(j);

                if (a.compareToIgnoreCase(b) > 0) {
                    String aux = resultado.get(i);
                    resultado.set(i, resultado.get(j));
                    resultado.set(j, aux);
                }
            }
        }

        return resultado;
    }

    // ============================================================
    // 20. FILTRAR CLAVES POR CONDICIÓN (ej: contador >= mínimo)
    // ============================================================
    public ArrayList<String> filtrarPorContador(int minimo) {
        ArrayList<String> resultado = new ArrayList<>();

        for (String clave : mapaContador.keySet()) {
            int valor = mapaContador.get(clave);

            if (valor >= minimo) {
                resultado.add(clave);
            }
        }

        return resultado;
    }

    // ============================================================
    // 21. COPIAR MAPA ENTERO A OTRO MAPA (putAll)
    // ============================================================
    public void copiarEn(HashMap<String, String> destino) {
        destino.putAll(mapa);
    }

    // ============================================================
    // 22. OBTENER PRIMERA CLAVE (TreeMap)
    // ============================================================
    public String primeraClave(TreeMap<String, String> tree) {
        String resultado = tree.firstKey();
        return resultado;
    }

    // ============================================================
    // 23. OBTENER ÚLTIMA CLAVE (TreeMap)
    // ============================================================
    public String ultimaClave(TreeMap<String, String> tree) {
        String resultado = tree.lastKey();
        return resultado;
    }

    // ============================================================
    // 24. SUBMAPA (TreeMap)
    // ============================================================
    public SortedMap<String, String> subMapa(TreeMap<String, String> tree, String inicio, String fin) {
        SortedMap<String, String> resultado = tree.subMap(inicio, fin);
        return resultado;
    }
}