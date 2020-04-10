package br.com.mind5.business.form.formAddress.model.action;

import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.business.form.formAddress.info.FormessSetterDefault;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessEnforceDefault extends ActionVisitorTemplateEnforceV2<FormessInfo> {
	
	public VisiFormessEnforceDefault(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FormessInfo enforceHook(FormessInfo recordInfo) {
		FormessSetterDefault attrSetter = new FormessSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
