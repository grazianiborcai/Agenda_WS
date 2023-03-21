package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class OrdugeCopyOrderem extends InfoCopierTemplate<OrdugeInfo, OrderemInfo> {
	
	public OrdugeCopyOrderem() {
		super();
	}
	
	
	
	@Override protected OrdugeInfo makeCopyHook(OrderemInfo source) {		
		OrdugeInfo result = new OrdugeInfo();
		
		result.codOwner           = source.codOwner;
		result.username           = source.username;
		result.codPayOrder        = source.codPayOrder;
		result.codLanguage        = source.codLanguage;
		result.codOrderStatusOld  = source.codOrderStatus;
		result.statusOrderPartner = source.statusOrderPartner;
		
		return result;
	}
}
