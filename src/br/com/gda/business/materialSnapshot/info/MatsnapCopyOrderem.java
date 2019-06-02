package br.com.gda.business.materialSnapshot.info;


import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class MatsnapCopyOrderem extends InfoCopierTemplate<MatsnapInfo, OrderemInfo>{
	
	public MatsnapCopyOrderem() {
		super();
	}
	
	
	
	@Override protected MatsnapInfo makeCopyHook(OrderemInfo source) {
		MatsnapInfo result = new MatsnapInfo();
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codSnapshot = source.codMatSnapshot;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
