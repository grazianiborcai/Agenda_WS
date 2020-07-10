package br.com.mind5.business.materialSearch.info;


import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatarchCopyOrderem extends InfoCopierTemplate<MatarchInfo, OrderemInfo> {
	
	public MatarchCopyOrderem() {
		super();
	}
	
	
	
	@Override protected MatarchInfo makeCopyHook(OrderemInfo source) {
		MatarchInfo result = new MatarchInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
