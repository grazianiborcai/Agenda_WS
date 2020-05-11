package br.com.mind5.business.orderStatusChange.info;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopier;

public final class OrdugeCopier {	
	public static OrdugeInfo copyFromOrder(OrderInfo source) {
		InfoCopier<OrdugeInfo, OrderInfo> copier = new OrdugeCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdugeInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopier<OrdugeInfo, OrderInfo> copier = new OrdugeCopyOrder();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static OrdugeInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<OrdugeInfo, OrderemInfo> copier = new OrdugeCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdugeInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<OrdugeInfo, OrderemInfo> copier = new OrdugeCopyOrderem();
		return copier.makeCopy(sources);
	}	
}
