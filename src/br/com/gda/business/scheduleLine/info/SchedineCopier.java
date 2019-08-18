package br.com.gda.business.scheduleLine.info;


import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierTemplate;

public final class SchedineCopier {	
	public static SchedineInfo copyFromOrderem(OrderemInfo source) {
		InfoCopierTemplate<SchedineInfo, OrderemInfo> copier = new SchedineCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedineInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopierTemplate<SchedineInfo, OrderemInfo> copier = new SchedineCopyOrderem();
		return copier.makeCopy(sources);
	}
}
