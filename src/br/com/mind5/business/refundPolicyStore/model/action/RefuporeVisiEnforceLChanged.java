package br.com.mind5.business.refundPolicyStore.model.action;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiEnforceLChanged extends ActionVisitorTemplateEnforce<RefuporeInfo> {
	
	public RefuporeVisiEnforceLChanged(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}

	
	
	@Override protected RefuporeInfo enforceHook(RefuporeInfo recordInfo) {
		InfoSetter<RefuporeInfo> attrSetter = new RefuporeSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
