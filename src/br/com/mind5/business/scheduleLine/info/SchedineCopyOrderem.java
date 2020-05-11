package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedineCopyOrderem extends InfoCopierTemplate<SchedineInfo, OrderemInfo> {
	
	public SchedineCopyOrderem() {
		super();
	}
	
	
	
	@Override protected SchedineInfo makeCopyHook(OrderemInfo source) {
		SchedineInfo result = new SchedineInfo();
		
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codOrderItem = source.codOrderItem;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
