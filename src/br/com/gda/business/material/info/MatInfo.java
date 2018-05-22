package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.info.MatUnitInfo;
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
	}
	
	
	
	public LanguInfo toLanguInfo() {
		LanguInfo langu = new LanguInfo();
		langu.codLanguage = this.codLanguage;
		return langu;
	}
	
	
	
	public CurrencyInfo toCurrencyInfo() {
		CurrencyInfo currency = new CurrencyInfo();		
		currency.codCurr = this.codCurr;
		currency.txtCurr = this.txtCurr;
		currency.codLanguage = this.codLanguage;
		return currency;
	}
	
	
	
	public MatUnitInfo toMatUnitInfo() {
		MatUnitInfo unit = new MatUnitInfo();		
		unit.codUnit = this.codUnit;
		unit.txtUnit = this.txtUnit;
		unit.codLanguage = this.codLanguage;
		return unit;
	}
	
	
	
	public MatCategInfo toMatCategInfo() {
		MatCategInfo categ = new MatCategInfo();		
		categ.codCategory = this.codCategory;
		categ.txtCategory = this.txtCategory;
		categ.codLanguage = this.codLanguage;
		return categ;
	}
	
	
	
	public MatGroupInfo toMatGroupInfo() {
		MatGroupInfo group = new MatGroupInfo();		
		group.codGroup = this.codGroup;
		group.txtGroup = this.txtGroup;		
		group.codBusiness = this.codBusiness;
		group.txtBusiness = this.txtBusiness;
		group.codLanguage = this.codLanguage;
		return group;
	}
	
	
	
	public MatTypeInfo toMatTypeInfo() {
		MatTypeInfo categ = new MatTypeInfo();		
		categ.codType = this.codType;
		categ.txtType = this.txtType;
		categ.codLanguage = this.codLanguage;
		return categ;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
