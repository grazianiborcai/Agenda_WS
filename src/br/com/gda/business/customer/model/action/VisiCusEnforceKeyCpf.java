package br.com.gda.business.customer.model.action;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCusEnforceKeyCpf extends ActionVisitorTemplateEnforce<CusInfo> {
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		CusInfo enforcedRecord = new CusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codCustomer = recordInfo.codCustomer;
		enforcedRecord.cpf = recordInfo. cpf;
		return enforcedRecord;
	}
}
