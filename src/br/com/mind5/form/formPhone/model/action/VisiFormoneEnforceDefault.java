package br.com.mind5.form.formPhone.model.action;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.info.FormoneSetterDefault;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormoneEnforceDefault extends ActionVisitorTemplateEnforce<FormoneInfo> {
	
	public VisiFormoneEnforceDefault(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FormoneInfo enforceHook(FormoneInfo recordInfo) {
		InfoSetterTemplate<FormoneInfo> attrSetter = new FormoneSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
