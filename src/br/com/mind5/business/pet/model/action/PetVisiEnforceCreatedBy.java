package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<PetInfo> {
	
	public PetVisiEnforceCreatedBy(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PetInfo enforceHook(PetInfo recordInfo) {
		InfoSetter<PetInfo> attrSetter = new PetSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
