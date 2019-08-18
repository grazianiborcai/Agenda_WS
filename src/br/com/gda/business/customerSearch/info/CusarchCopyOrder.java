package br.com.gda.business.customerSearch.info;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CusarchCopyOrder extends InfoCopierTemplate<CusarchInfo, OrderInfo>{
	
	public CusarchCopyOrder() {
		super();
	}
	
	
	
	@Override protected CusarchInfo makeCopyHook(OrderInfo source) {
		CusarchInfo result = new CusarchInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
