package br.com.gda.business.company.model.action;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCompEnforceCnpj extends ActionVisitorTemplateEnforce<CompInfo> {
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		CompInfo enforcedRecord = new CompInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.cnpj = recordInfo.cnpj;
		enforcedRecord.codEntityCateg = recordInfo.codEntityCateg;
		return enforcedRecord;
	}
}
