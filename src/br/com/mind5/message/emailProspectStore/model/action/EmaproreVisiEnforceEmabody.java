package br.com.mind5.message.emailProspectStore.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.info.EmaproreSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmaproreVisiEnforceEmabody extends ActionVisitorTemplateEnforce<EmaproreInfo> {
	
	public EmaproreVisiEnforceEmabody(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmaproreInfo enforceHook(EmaproreInfo recordInfo) {
		InfoSetter<EmaproreInfo> attrSetter = new EmaproreSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
