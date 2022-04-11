package br.com.mind5.business.personBio.model.action;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<PerbioInfo> {
	
	public PerbioVisiEnforceCreatedBy(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PerbioInfo enforceHook(PerbioInfo recordInfo) {
		InfoSetter<PerbioInfo> attrSetter = new PerbioSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
