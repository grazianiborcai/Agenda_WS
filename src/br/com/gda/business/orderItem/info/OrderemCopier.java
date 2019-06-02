package br.com.gda.business.orderItem.info;


import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

public final class OrderemCopier {
	public static List<OrderemInfo> copyFromOrder(OrderInfo source) {
		InfoCopierOneToManyTemplate<OrderemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrderemInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopierOneToManyTemplate<OrderemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(sources);
	}
}
