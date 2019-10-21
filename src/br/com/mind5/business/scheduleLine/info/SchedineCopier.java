package br.com.mind5.business.scheduleLine.info;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoCopier;

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
