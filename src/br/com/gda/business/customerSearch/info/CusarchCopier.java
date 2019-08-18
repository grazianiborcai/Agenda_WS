package br.com.gda.business.customerSearch.info;


import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopier;

public final class CusarchCopier {	
	public static CusarchInfo copyFromOrder(OrderInfo source) {
		InfoCopier<CusarchInfo, OrderInfo> copier = new CusarchCopyOrder();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusarchInfo> copyFromOrder(List<OrderInfo> sources) {
		InfoCopier<CusarchInfo, OrderInfo> copier = new CusarchCopyOrder();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CusarchInfo copyFromCusEmail(CusInfo source) {
		InfoCopier<CusarchInfo, CusInfo> copier = new CusarchCopyCusEmail();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusarchInfo> copyFromCusEmail(List<CusInfo> sources) {
		InfoCopier<CusarchInfo, CusInfo> copier = new CusarchCopyCusEmail();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CusarchInfo copyFromCusCpf(CusInfo source) {
		InfoCopier<CusarchInfo, CusInfo> copier = new CusarchCopyCusCpf();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusarchInfo> copyFromCusCpf(List<CusInfo> sources) {
		InfoCopier<CusarchInfo, CusInfo> copier = new CusarchCopyCusCpf();
		return copier.makeCopy(sources);
	}
}
