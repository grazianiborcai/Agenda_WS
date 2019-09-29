package br.com.gda.business.companySearch.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.companySearch.info.ComparchInfo;
import br.com.gda.info.InfoCopierTemplate;

final class ComparchCopyCompCnpj extends InfoCopierTemplate<ComparchInfo, CompInfo>{
	
	public ComparchCopyCompCnpj() {
		super();
	}
	
	
	
	@Override protected ComparchInfo makeCopyHook(CompInfo source) {
		ComparchInfo result = new ComparchInfo();
		result.codOwner = source.codOwner;
		result.cnpj = source.cnpj;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
