import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> hashtable = new Hashtable<String, ArrayList<String>>();

        ArrayList<String> listaContatosMilena = new ArrayList<String>();
        ArrayList<String> listaContatosJavier = new ArrayList<String>();
        ArrayList<String> listaContatosYadira = new ArrayList<String>();
        ArrayList<String> listaContatosLucia = new ArrayList<String>();
        ArrayList<String> listaContatosJuan = new ArrayList<String>();
        ArrayList<String> listaContatosMaria = new ArrayList<String>();
        ArrayList<String> listaContatosAndres = new ArrayList<String>();

        listaContatosMilena.add("Yadira");
        listaContatosMilena.add("Juan");

        listaContatosJavier.add("Andrés");
        listaContatosJavier.add("Yadira");
        listaContatosJavier.add("Milena");

        listaContatosYadira.add("Lucia");

        listaContatosJuan.add("Lucia");
        listaContatosJuan.add("Maria");
        listaContatosJuan.add("Milena");

        listaContatosAndres.add("Maria");

        hashtable.put("Milena", listaContatosMilena);
        hashtable.put("Javier", listaContatosJavier);
        hashtable.put("Yadira", listaContatosYadira);
        hashtable.put("Juan", listaContatosJuan);
        hashtable.put("Andres", listaContatosAndres);

        apresentarDados(hashtable);
        System.out.println(pesquisaEmLargura(hashtable, "Milena"));
    }

    private static void apresentarDados(Hashtable<String, ArrayList<String>> hashtable) {
        for (Map.Entry<String, ArrayList<String>> entidade : hashtable.entrySet()) {
            String chave = entidade.getKey();
            ArrayList<String> valor = entidade.getValue();

            System.out.println(chave + " / " + valor);
        }
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> hashtable, String verticeInicial) {
        Queue<String> queue = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        queue = enfileirarDados(queue, (ArrayList<String>)hashtable.get(verticeInicial));

        while (queue.size() > 0){
            String pessoa = queue.poll();

            if (pessoa.equals("Maria")){
                System.out.println("");
                return "Maria foi encontrada. :)";
            }

            if (verificados.contains(pessoa)){
                continue;
            }

            queue = enfileirarDados(queue, (ArrayList<String>)hashtable.get(pessoa));
        }

        System.out.println("");
        return "Maria não foi encontrada! :(";
    }

    private static Queue<String> enfileirarDados(Queue<String> queue, ArrayList<String> lista){
        if (lista == null)
            return queue;

        for (String item : lista){
            queue.offer(item);
        }

        return queue;
    }

}
