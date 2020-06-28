package br.com.mind5.business.companySearch.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class ComparchCopyComp extends InfoCopierTemplate<ComparchInfo, CompInfo> {
	
	public ComparchCopyComp() {
		super();
	}
	
	
	
	@Override protected ComparchInfo makeCopyHook(CompInfo source) {
		ComparchInfo result = new ComparchInfo();
		
		result.codOwner = source.codOwner;
		result.cnpj = source.cnpj;
		result.codEntityCateg = source.codEntityCateg;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
