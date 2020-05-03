package br.com.mind5.business.orderItemSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class OrdemarchCopier {
	public static OrdemarchInfo copyFromOrder(RefuInfo source) {
		InfoCopierTemplate<OrdemarchInfo, RefuInfo> copier = new OrdemarchCopyRefu();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdemarchInfo> copyFromOrder(List<RefuInfo> sources) {
		InfoCopierTemplate<OrdemarchInfo, RefuInfo> copier = new OrdemarchCopyRefu();
		return copier.makeCopy(sources);
	}
}
