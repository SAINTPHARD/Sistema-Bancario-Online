package entities;

public enum TipoConta {

	//tipos de conta disponíveis
	CONTA_CORRENTE("Conta Corrente"),
	CONTA_POUPANCA("Conta Poupança"),
	CONTA_SALARIO("Conta Salário"),
	CONTA_INVESTIMENTO("Conta Investimento");
	
	//construtores de enum
	private String descricao; // descrição da conta
	
	private TipoConta(String descricao) { // construtor privado para inicializar a descrição
		this.descricao = descricao;
	}

	// método para obter a descrição da conta
	public String getDescricao() {       
		return descricao;
	}

	public void setDescricao(String descricao) { 
		this.descricao = descricao;
	}
	// método para obter o nome da enum
	public static TipoConta fromString(String descricao) {
		for (TipoConta tipo : TipoConta.values()) {
			if (tipo.getDescricao().equalsIgnoreCase(descricao)) { // compara a descrição com a string fornecida
				return tipo; // retorna o tipo de conta correspondente à descrição
			}
		}
		return null;
	}
	
}
