package br.com.gda.payment.payOrderItem.info;


import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.info.InfoCopierTemplate;

public final class OrderemCopier {
	public static List<PayordemInfo> copyFromOrder(OrderInfo source) {
		InfoCopierOneToManyTemplate<PayordemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopierOneToManyTemplate<PayordemInfo, OrderInfo> copier = new OrderemCopyOrder();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PayordemInfo copyFromCartem(CartemInfo source) {
		InfoCopierTemplate<PayordemInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopierTemplate<PayordemInfo, CartemInfo> copier = new OrderemCopyCartem();
		return copier.makeCopy(sources);
	}
}
