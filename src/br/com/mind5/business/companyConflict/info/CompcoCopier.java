package br.com.mind5.business.companyConflict.info;


import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.info.InfoCopier;

public final class CompcoCopier {
	public static CompcoInfo copyFromCompCnpj(CompInfo source) {
		InfoCopier<CompcoInfo, CompInfo> copier = new CompcoCopyCompCnpj();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CompcoInfo> copyFromCompCnpj(List<CompInfo> sources) {
		InfoCopier<CompcoInfo, CompInfo> copier = new CompcoCopyCompCnpj();
		return copier.makeCopy(sources);
	}
}
