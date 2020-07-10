package br.com.mind5.business.material.info;


import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatCopyOrderem extends InfoCopierTemplate<MatInfo, OrderemInfo> {
	
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
