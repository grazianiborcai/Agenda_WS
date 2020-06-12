package br.com.mind5.message.emailProspectStore.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.info.EmaproreSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmaproreEnforceEmabody extends ActionVisitorTemplateEnforceV2<EmaproreInfo> {
	
	public VisiEmaproreEnforceEmabody(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmaproreInfo enforceHook(EmaproreInfo recordInfo) {
		InfoSetter<EmaproreInfo> attrSetter = new EmaproreSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
