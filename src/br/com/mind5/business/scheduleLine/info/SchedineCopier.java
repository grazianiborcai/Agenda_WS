package br.com.mind5.business.scheduleLine.info;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
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
	
	
	public static SchedineInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<SchedineInfo, OrderemInfo> copier = new SchedineCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedineInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<SchedineInfo, OrderemInfo> copier = new SchedineCopyOrderem();
		return copier.makeCopy(sources);
	}
}
