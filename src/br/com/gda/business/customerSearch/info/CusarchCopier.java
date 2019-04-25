package br.com.gda.business.customerSearch.info;


import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopier;

public final class CusarchCopier {	
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
