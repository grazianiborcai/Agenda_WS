package br.com.mind5.masterData.refundPolicyGroup.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupSetterDefault;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupVisiEnforceDefault extends ActionVisitorTemplateEnforce<RefugroupInfo> {
	
	public RefugroupVisiEnforceDefault(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}

	
	
	@Override protected RefugroupInfo enforceHook(RefugroupInfo recordInfo) {
		InfoSetter<RefugroupInfo> attrSetter = new RefugroupSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
