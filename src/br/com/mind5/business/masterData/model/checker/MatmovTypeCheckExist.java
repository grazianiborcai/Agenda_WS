package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovTypeCheckExist extends ModelCheckerTemplateAction<MatmovTypeInfo, MatmovTypeInfo> {
	
	public MatmovTypeCheckExist(ModelCheckerOption option) {
		super(option, MatmovTypeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatmovTypeInfo> buildActionHook(DeciTreeOption<MatmovTypeInfo> option) {
		ActionStdV1<MatmovTypeInfo> select = new StdMatmovTypeSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MOV_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_TYPE_NOT_FOUND;
	}
}
