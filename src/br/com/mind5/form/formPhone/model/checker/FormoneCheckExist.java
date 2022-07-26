package br.com.mind5.form.formPhone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.action.FormoneVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormoneCheckExist extends ModelCheckerTemplateAction<FormoneInfo, FormoneInfo> {
	
	public FormoneCheckExist(ModelCheckerOption option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<FormoneInfo> buildActionHook(DeciTreeOption<FormoneInfo> option) {
		ActionStd<FormoneInfo> select = new ActionStdCommom<FormoneInfo>(option, FormoneVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_PHONE_NOT_FOUND;
	}
}
