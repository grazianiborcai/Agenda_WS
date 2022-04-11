package br.com.mind5.business.personBioSearch.model.action;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchSetterPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiorchVisiEnforcePersonKey extends ActionVisitorTemplateEnforce<PerbiorchInfo> {
	
	public PerbiorchVisiEnforcePersonKey(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	

	@Override protected PerbiorchInfo enforceHook(PerbiorchInfo recordInfo) {
		InfoSetter<PerbiorchInfo> attrSetter = new PerbiorchSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
