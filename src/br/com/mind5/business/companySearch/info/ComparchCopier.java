package br.com.mind5.business.companySearch.info;


import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoCopier;

public final class ComparchCopier {
	public static ComparchInfo copyFromComp(CompInfo source) {
		InfoCopier<ComparchInfo, CompInfo> copier = new ComparchCopyComp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<ComparchInfo> copyFromComp(List<CompInfo> sources) {
		InfoCopier<ComparchInfo, CompInfo> copier = new ComparchCopyComp();
		return copier.makeCopy(sources);
	}
}
