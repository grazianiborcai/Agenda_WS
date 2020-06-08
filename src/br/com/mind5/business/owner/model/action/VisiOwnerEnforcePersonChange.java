package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerEnforcePersonChange extends ActionVisitorTemplateEnforceV2<OwnerInfo> {
	
	public VisiOwnerEnforcePersonChange(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		OwnerInfo enforcedRecord = new OwnerInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.personData.codPerson = recordInfo.personData.codPerson;
		return enforcedRecord;
	}
}
