package controle_Hotel;

import java.util.HashMap;

import hotel.Novo_Hospede;

public class Controle_Hospede {
	
	private HashMap<String,Novo_Hospede> hospedes = new HashMap<>();

	public boolean salvar (Novo_Hospede h) {
		if (h != null) {
			hospedes.put(h.getCPF(),h);
			return true;
		}else {
			return false;
		}
	}
	public Novo_Hospede buscar(String CPF){
		if (hospedes.containsKey(CPF)) {
			return hospedes.get(CPF);
		}
		return null;
	}
	public Novo_Hospede remover(String CPF) {
		if (hospedes.containsKey(CPF)) {
			return hospedes.remove(CPF);
		}
		return null;
	}
}
