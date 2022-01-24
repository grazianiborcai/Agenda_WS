package br.com.mind5.business.personBio.model.action;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbioEnforceLChanged extends ActionVisitorTemplateEnforce<PerbioInfo> {
	
	public VisiPerbioEnforceLChanged(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PerbioInfo enforceHook(PerbioInfo recordInfo) {
		InfoSetter<PerbioInfo> attrSetter = new PerbioSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
