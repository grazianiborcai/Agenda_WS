package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopier;

public final class MatsnapCopier {
	public static MatsnapInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<MatsnapInfo, OrderemInfo> copier = new MatsnapCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatsnapInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<MatsnapInfo, OrderemInfo> copier = new MatsnapCopyOrderem();
		return copier.makeCopy(sources);
	}	
}
