package br.com.mind5.form.formAddress.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.FormessVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessCheckExist extends ModelCheckerTemplateAction<FormessInfo, FormessInfo> {
	
	public FormessCheckExist(ModelCheckerOption option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected ActionStd<FormessInfo> buildActionHook(DeciTreeOption<FormessInfo> option) {
		ActionStd<FormessInfo> select = new ActionStdCommom<FormessInfo>(option, FormessVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_ADDRESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_NOT_FOUND;
	}
}
