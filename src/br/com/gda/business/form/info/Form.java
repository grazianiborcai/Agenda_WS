package br.com.gda.business.form.info;

public enum Form {
	A01("A01");
	
	private final String codForm;
	
	
	private Form(String cod) {
		codForm = cod;
	}
	
	
	
	public String getCodForm() {
		return codForm;
	}
}
