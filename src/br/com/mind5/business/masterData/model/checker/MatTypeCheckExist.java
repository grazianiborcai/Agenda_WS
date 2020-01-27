package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatTypeSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatTypeCheckExist extends ModelCheckerTemplateActionV2<MatTypeInfo, MatTypeInfo> {
	
	public MatTypeCheckExist(ModelCheckerOption option) {
		super(option, MatTypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatTypeInfo> buildActionHook(DeciTreeOption<MatTypeInfo> option) {
		ActionStd<MatTypeInfo> select = new StdMatTypeSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
