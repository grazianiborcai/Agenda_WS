package br.com.gda.business.material.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class MatInfo implements Cloneable {
	public long codOwner;
	public long codMat;
	public String txtMat;
	public String description;
	public int codType;
	public String txtType;
	public int codCategory;
	public String txtCategory;
	public double price;
	public int priceUnit;
	public String codCurr;
	public String txtCurr;
	public String codUnit;
	public String txtUnit;
	public int codGroup;
	public String txtGroup; 
	public int codBusiness;
	public String txtBusiness; 
	public String codLanguage;
	public String recordMode;
	//TODO: testar material com preço com mais de 2 casas decimais
	
	
	public MatInfo() {
		this.codOwner = DefaultValue.number();		
		this.codMat = DefaultValue.number();
		this.codType = DefaultValue.number();
		this.codCategory = DefaultValue.number();
		this.price = DefaultValue.number();
		this.priceUnit = 1;
		this.codGroup = DefaultValue.number();		
		this.codBusiness = DefaultValue.number();	
		this.codLanguage = Language.getDefaultLanguage();
		this.codOwner = DefaultValue.number();
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
