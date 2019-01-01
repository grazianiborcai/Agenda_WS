package br.com.gda.payService.payCustomer.model.action;

import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class VisiPayCusEnforcePersonChange extends ActionVisitorTemplateEnforce<PayCusInfo> {
	
	@Override protected PayCusInfo enforceHook(PayCusInfo recordInfo) {
		PayCusInfo enforcedRecord = new PayCusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codUser = recordInfo.codUser;
		enforcedRecord.codPerson = recordInfo.codPerson;
		return enforcedRecord;
	}
}
