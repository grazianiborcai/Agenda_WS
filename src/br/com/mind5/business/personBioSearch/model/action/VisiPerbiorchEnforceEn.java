package br.com.mind5.business.personBioSearch.model.action;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchSetterEn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbiorchEnforceEn extends ActionVisitorTemplateEnforce<PerbiorchInfo> {
	
	public VisiPerbiorchEnforceEn(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PerbiorchInfo enforceHook(PerbiorchInfo recordInfo) {
		InfoSetter<PerbiorchInfo> attrSetter = new PerbiorchSetterEn();
		return attrSetter.setAttr(recordInfo);
	}
}
