package br.com.mind5.business.addressSearch.info;


import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopier;

public final class AddarchCopier {	
	public static AddarchInfo copyFromCusKey(CusInfo source) {
		InfoCopier<AddarchInfo, CusInfo> copier = new AddarchCopyCusKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromCusKey(List<CusInfo> sources) {
		InfoCopier<AddarchInfo, CusInfo> copier = new AddarchCopyCusKey();
		return copier.makeCopy(sources);
	}
}
