package br.com.mind5.form.formAddress.model.action;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.info.FormessSetterDefault;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessEnforceDefault extends ActionVisitorTemplateEnforce<FormessInfo> {
	
	public VisiFormessEnforceDefault(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FormessInfo enforceHook(FormessInfo recordInfo) {
		InfoSetterTemplate<FormessInfo> attrSetter = new FormessSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
