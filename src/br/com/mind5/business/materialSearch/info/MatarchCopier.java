package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoCopier;

public final class MatarchCopier {
	public static MatarchInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<MatarchInfo, OrderemInfo> copier = new MatarchCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatarchInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<MatarchInfo, OrderemInfo> copier = new MatarchCopyOrderem();
		return copier.makeCopy(sources);
	}	
}
