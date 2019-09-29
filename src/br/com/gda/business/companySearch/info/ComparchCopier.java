package br.com.gda.business.companySearch.info;


import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.companySearch.info.ComparchInfo;
import br.com.gda.info.InfoCopier;

public final class ComparchCopier {
	public static ComparchInfo copyFromComp(CompInfo source) {
		InfoCopier<ComparchInfo, CompInfo> copier = new ComparchCopyCompCnpj();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<ComparchInfo> copyFromComp(List<CompInfo> sources) {
		InfoCopier<ComparchInfo, CompInfo> copier = new ComparchCopyCompCnpj();
		return copier.makeCopy(sources);
	}
}
