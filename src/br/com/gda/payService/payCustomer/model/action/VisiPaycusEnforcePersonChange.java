package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class VisiPaycusEnforcePersonChange extends ActionVisitorTemplateEnforce<PaycusInfo> {
	
	@Override protected PaycusInfo enforceHook(PaycusInfo recordInfo) {
		PaycusInfo enforcedRecord = new PaycusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		enforcedRecord.codPerson = recordInfo.codPerson;
		return enforcedRecord;
	}
}
