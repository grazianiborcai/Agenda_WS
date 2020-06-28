package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CompSetterCnpj extends InfoSetterTemplate<CompInfo> {
	
	@Override protected CompInfo setAttrHook(CompInfo recordInfo) {
		CompInfo result = new CompInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.cnpj = recordInfo.cnpj;
		result.codEntityCateg = recordInfo.codEntityCateg;
		
		return result;
	}
}
