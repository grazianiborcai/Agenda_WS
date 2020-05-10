package br.com.mind5.business.orderSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class OrdarchCopyRefem extends InfoCopierTemplate<OrdarchInfo, RefemInfo> {
	
	public OrdarchCopyRefem() {
		super();
	}
	
	
	
	@Override protected OrdarchInfo makeCopyHook(RefemInfo source) {		
		OrdarchInfo result = new OrdarchInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
