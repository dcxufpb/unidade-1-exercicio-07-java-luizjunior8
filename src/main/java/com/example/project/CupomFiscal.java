package com.example.project;

public class CupomFiscal {

	public static String Spacer = System.lineSeparator();

	public static boolean checker (String tested){
		String k = "";
		k += tested;
		if (k.equals("null")|| k.isEmpty()){
			return false;
		}	
		return true;	
	}

	public static String dadosLojaParam(String nomeLoja, String logradouro, int numero, String complemento,
			String bairro, String municipio, String estado, String cep, String telefone, String observacao, String cnpj,
			String inscricaoEstadual) {
	
				
		if (nomeLoja.isEmpty()){
			throw new RuntimeException ("O campo nome da loja é obrigatório");
		}

		if (logradouro.isEmpty()){
			throw new RuntimeException ("O campo logradouro do endereço é obrigatório");
		}

		String _logradouro = logradouro + ", ";
		String _numero = "0";

		if (numero == 0){
			_numero = "s/n";
		}else{
			_numero = String.format ("%d", numero);
		}

		String _complemento = (complemento.isEmpty()) ? "" : " " + complemento;

		String _bairro = bairro.isEmpty() ? "" : bairro + " - ";

		if (municipio.isEmpty()){
			throw new RuntimeException ("O campo município do endereço é obrigatório");			
		}

		String _municipio = municipio + " - ";

		if (estado.isEmpty()){
			throw new RuntimeException ("O campo estado do endereço é obrigatório");
		}

		String _cep = "";

		if (checker(cep) == true){
			_cep = "CEP:" + cep;
		}

		String _telefone = telefone.isEmpty()? "" : "Tel " + telefone;

	 	if (!_cep.isEmpty() && !_telefone.isEmpty()){
			_telefone = " Tel " + telefone;
		}

		String _observacao = observacao.isEmpty() ? "" : observacao;

		if (checker(cnpj) == false){
			throw new RuntimeException ("O campo CNPJ da loja é obrigatório");
		}
		
		String _cnpj = "CNPJ: " + cnpj;

 	 	if (inscricaoEstadual.isEmpty()){
			throw new RuntimeException ("O campo inscrição estadual da loja é obrigatório");
		}
		String _inscricao_estadual = "IE: " + inscricaoEstadual; 

		return (nomeLoja + Spacer +
		 _logradouro + _numero + _complemento + Spacer +
		 _bairro + _municipio + estado + Spacer +
		 _cep + _telefone + Spacer +
		 _observacao + Spacer +	
		 _cnpj + Spacer +
		 _inscricao_estadual + Spacer);
	}

} 
