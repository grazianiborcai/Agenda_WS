package br.com.mind5.business.orderSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrdarchCopyPayord extends InfoCopierTemplate<OrdarchInfo, PayordInfo> {
	
	public OrdarchCopyPayord() {
		super();
	}
	
	
	
	@Override protected OrdarchInfo makeCopyHook(PayordInfo source) {		
		OrdarchInfo result = new OrdarchInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
