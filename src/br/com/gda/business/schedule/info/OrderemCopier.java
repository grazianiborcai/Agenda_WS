package br.com.gda.business.schedule.info;


import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.info.InfoCopierTemplate;

public final class OrderemCopier {
	public static List<ScheduInfo> copyFromOrder(OrderInfo source) {
		InfoCopierOneToManyTemplate<ScheduInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<ScheduInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopierOneToManyTemplate<ScheduInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(sources);
	}
	
	
	
	public static ScheduInfo copyFromCartem(CartemInfo source) {
		InfoCopierTemplate<ScheduInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<ScheduInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopierTemplate<ScheduInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(sources);
	}
}
