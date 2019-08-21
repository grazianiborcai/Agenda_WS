package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierTemplate;

final class SchedineCopyOrderKey extends InfoCopierTemplate<SchedineInfo, OrderInfo>{
	
	public SchedineCopyOrderKey() {
		super();
	}
	
	
	
	@Override protected SchedineInfo makeCopyHook(OrderInfo source) {
		SchedineInfo result = new SchedineInfo();
		result.codOwner = source.codOwner;
		result.codOrder = source.codOrder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
