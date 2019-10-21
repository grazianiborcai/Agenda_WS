package br.com.mind5.business.customer.info;


import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopier;

public final class CusCopier {	
	public static CusInfo copyFromCusKey(CusInfo source) {
		InfoCopier<CusInfo, CusInfo> copier = new CusCopyCusKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusInfo> copyFromCusKey(List<CusInfo> sources) {
		InfoCopier<CusInfo, CusInfo> copier = new CusCopyCusKey();
		return copier.makeCopy(sources);
	}
}
