package br.com.gda.business.scheduleLine.info;


import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.info.InfoCopierTemplate;

public final class OrderemCopier {
	public static List<SchedineInfo> copyFromOrder(OrderInfo source) {
		InfoCopierOneToManyTemplate<SchedineInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedineInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopierOneToManyTemplate<SchedineInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(sources);
	}
	
	
	
	public static SchedineInfo copyFromCartem(CartemInfo source) {
		InfoCopierTemplate<SchedineInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedineInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopierTemplate<SchedineInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(sources);
	}
}
