package br.com.mind5.business.materialTextDefault.model.checker;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.action.StdMatextaultSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextaultCheckExist extends ModelCheckerTemplateAction<MatextaultInfo, MatextaultInfo> {
	
	public MatextaultCheckExist(ModelCheckerOption option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextaultInfo> buildActionHook(DeciTreeOption<MatextaultInfo> option) {
		ActionStd<MatextaultInfo> select = new StdMatextaultSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_DEFAULT_NOT_FOUND;
	}
}
