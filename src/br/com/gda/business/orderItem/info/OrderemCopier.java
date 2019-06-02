package br.com.gda.business.orderItem.info;


import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.info.InfoCopierTemplate;

public final class OrderemCopier {
	public static List<OrderemInfo> copyFromOrder(OrderInfo source) {
		InfoCopierOneToManyTemplate<OrderemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderemInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopierOneToManyTemplate<OrderemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(sources);
	}
	
	
	
	public static OrderemInfo copyFromCartem(CartemInfo source) {
		InfoCopierTemplate<OrderemInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderemInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopierTemplate<OrderemInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(sources);
	}
}
