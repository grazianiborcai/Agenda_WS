package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterIdPayment extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {		
		recordInfo.codOwner        = getOwner(recordInfo);
		recordInfo.codPayOrder     = getPayord(recordInfo);
		recordInfo.codPayOrderItem = getPayordem(recordInfo);

		return recordInfo;
	}
	
	
	
	private long getOwner(PagookInfo recordInfo) {
		String[] parts = getParts(recordInfo);
		
		if (parts.length < 1)
			return DefaultValue.number();
		
		return Long.valueOf(parts[0]);
	}
	
	
	
	private long getPayord(PagookInfo recordInfo) {
		String[] parts = getParts(recordInfo);
		
		if (parts.length < 2)
			return DefaultValue.number();
		
		return Long.valueOf(parts[1]);
	}
	
	
	
	private long getPayordem(PagookInfo recordInfo) {
		String[] parts = getParts(recordInfo);
		
		if (parts.length < 3)
			return DefaultValue.number();
		
		return Long.valueOf(parts[2]);
	}
	
	
	
	private String[] getParts(PagookInfo recordInfo) {
		String[] emptyArray = {};
		
		if (recordInfo.data == null)
			return emptyArray;
		
		if (recordInfo.data.code == null)
			return emptyArray;
		
		return recordInfo.data.code.split("-");
	}
}
