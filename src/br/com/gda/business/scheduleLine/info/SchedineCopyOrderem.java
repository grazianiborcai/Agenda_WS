package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class SchedineCopyOrderem extends InfoCopierTemplate<SchedineInfo, OrderemInfo>{
	
	public SchedineCopyOrderem() {
		super();
	}
	
	
	
	@Override protected SchedineInfo makeCopyHook(OrderemInfo source) {
		return SchedineInfo.copyFrom(source);
	}
}
