package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatTypeSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatTypeCheckExist extends ModelCheckerTemplateAction<MatTypeInfo, MatTypeInfo> {
	
	public MatTypeCheckExist(ModelCheckerOption option) {
		super(option, MatTypeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatTypeInfo> buildActionHook(DeciTreeOption<MatTypeInfo> option) {
		ActionStdV1<MatTypeInfo> select = new StdMatTypeSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
