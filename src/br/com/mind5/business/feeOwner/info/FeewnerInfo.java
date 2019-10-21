package br.com.mind5.business.feeOwner.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FeewnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public char codFeeCateg;
	public String txtFeeCateg;
	public String codCurr;
	public double price;
	public String username;
	//TODO: inserir FeeType para definir a estrategia de cobranca: cobrar do cliente ou do lojista
	
	public FeewnerInfo() {
		super(FeewnerInfo.class);
		
		codOwner = DefaultValue.number();
		codFeeCateg = DefaultValue.character();
		price = DefaultValue.number();
	}
	
	
	
	public static FeewnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeewnerInfo.class);
	}
	
	
	
	public static List<FeewnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeewnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));		
		result = result * 31 + (int) (codFeeCateg);
		
		if (codCurr != null) 
			result = result * codCurr.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FeewnerInfo))
			return false;
		
		
		FeewnerInfo obj = (FeewnerInfo) o;		
		return (codOwner 	== obj.codOwner 	&&				
				codFeeCateg == obj.codFeeCateg 	&&
				super.isStringEqual(codCurr, obj.codCurr));
	}
}
