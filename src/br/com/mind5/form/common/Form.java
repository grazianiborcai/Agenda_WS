package br.com.mind5.form.common;

public enum Form {
	A00("A00"), 
	A01("A01"), 
	T00("T00"), 
	T01("T01");
	
	private final String codForm;
	
	
	private Form(String cod) {
		codForm = cod;
	}
	
	
	
	public String getCodForm() {
		return codForm;
	}
}
