package br.com.mind5.business.companyConflict.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CompcoCopyCompCnpj extends InfoCopierTemplate<CompcoInfo, CompInfo>{
	
	public CompcoCopyCompCnpj() {
		super();
	}
	
	
	
	@Override protected CompcoInfo makeCopyHook(CompInfo source) {
		CompcoInfo result = new CompcoInfo();
		
		result.codOwner = source.codOwner;
		result.codCompany = source.codCompany;
		result.cnpj = source.cnpj;
		result.codEntityCateg = source.codEntityCateg;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
