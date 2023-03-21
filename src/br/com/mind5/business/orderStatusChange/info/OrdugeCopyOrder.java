package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class OrdugeCopyOrder extends InfoCopierTemplate<OrdugeInfo, OrderInfo> {
	
	public OrdugeCopyOrder() {
		super();
	}
	
	
	
	@Override protected OrdugeInfo makeCopyHook(OrderInfo source) {		
		OrdugeInfo result = new OrdugeInfo();
		
		result.codOwner           = source.codOwner;		
		result.username           = source.username;
		result.codPayOrder        = source.codPayOrder;		
		result.codLanguage        = source.codLanguage;
		result.codPayPartner      = source.codPayPartner;
		result.codOrderStatusOld  = source.codOrderStatus;
		result.statusOrderPartner = source.statusOrderPartner;
		
		return result;
	}
}
