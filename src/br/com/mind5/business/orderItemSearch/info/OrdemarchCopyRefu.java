package br.com.mind5.business.orderItemSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class OrdemarchCopyRefu extends InfoCopierTemplate<OrdemarchInfo, RefuInfo> {
	
	public OrdemarchCopyRefu() {
		super();
	}
	
	
	
	@Override protected OrdemarchInfo makeCopyHook(RefuInfo source) {	
		OrdemarchInfo result = new OrdemarchInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
