package br.com.gda.business.material.info;


import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatCopyOrderem extends InfoCopierTemplate<MatInfo, OrderemInfo>{
	
	public MatCopyOrderem() {
		super();
	}
	
	
	
	@Override protected MatInfo makeCopyHook(OrderemInfo source) {
		MatInfo result = new MatInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
