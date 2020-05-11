package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class OrdugeCopyOrderem extends InfoCopierTemplate<OrdugeInfo, OrderemInfo> {
	
	public OrdugeCopyOrderem() {
		super();
	}
	
	
	
	@Override protected OrdugeInfo makeCopyHook(OrderemInfo source) {		
		OrdugeInfo result = new OrdugeInfo();
		
		result.codOrderStatusOld = source.codOrderStatus;
		result.codPayOrder = source.codPayOrder;
		result.statusOrderPartner = source.statusOrderPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
