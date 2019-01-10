package br.com.gda.business.owner.model.action;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOwnerEnforcePersonChange extends ActionVisitorTemplateEnforce<OwnerInfo> {
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		OwnerInfo enforcedRecord = new OwnerInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.personData.codPerson = recordInfo.personData.codPerson;
		return enforcedRecord;
	}
}
