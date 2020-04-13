package br.com.mind5.form.formAddress.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.StdFormessDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessCheckExist extends ModelCheckerTemplateActionV2<FormessInfo, FormessInfo> {
	
	public FormessCheckExist(ModelCheckerOption option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FormessInfo> buildActionHook(DeciTreeOption<FormessInfo> option) {
		ActionStdV1<FormessInfo> select = new StdFormessDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_ADDRESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_NOT_FOUND;
	}
}
