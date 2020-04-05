package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiOwnerEnforcePersonChange extends ActionVisitorTemplateEnforceV1<OwnerInfo> {
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		OwnerInfo enforcedRecord = new OwnerInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.personData.codPerson = recordInfo.personData.codPerson;
		return enforcedRecord;
	}
}
