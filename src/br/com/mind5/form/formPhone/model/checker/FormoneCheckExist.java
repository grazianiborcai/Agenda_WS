package br.com.mind5.form.formPhone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.action.StdFormoneDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormoneCheckExist extends ModelCheckerTemplateActionV2<FormoneInfo, FormoneInfo> {
	
	public FormoneCheckExist(ModelCheckerOption option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FormoneInfo> buildActionHook(DeciTreeOption<FormoneInfo> option) {
		ActionStdV1<FormoneInfo> select = new StdFormoneDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_PHONE_NOT_FOUND;
	}
}
