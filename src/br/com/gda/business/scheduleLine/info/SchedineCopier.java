package br.com.gda.business.scheduleLine.info;

import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopier;

public final class SchedineCopier {
	public static SchedineInfo copyFromOrderKey(OrderInfo source) {
		InfoCopier<SchedineInfo, OrderInfo> copier = new SchedineCopyOrderKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedineInfo> copyFromOrderKey(List<OrderInfo> sources) {
		InfoCopier<SchedineInfo, OrderInfo> copier = new SchedineCopyOrderKey();
		return copier.makeCopy(sources);
	}
}
