package br.com.mind5.business.personBioSearch.model.action;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchSetterPt;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbiorchEnforcePt extends ActionVisitorTemplateEnforce<PerbiorchInfo> {
	
	public VisiPerbiorchEnforcePt(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	

	@Override protected PerbiorchInfo enforceHook(PerbiorchInfo recordInfo) {
		InfoSetter<PerbiorchInfo> attrSetter = new PerbiorchSetterPt();
		return attrSetter.setAttr(recordInfo);
	}
}
