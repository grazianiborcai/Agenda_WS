package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.action.StdMatGroupSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatGroupCheckExist extends ModelCheckerTemplateAction<MatGroupInfo, MatGroupInfo> {
	
	public MatGroupCheckExist(ModelCheckerOption option) {
		super(option, MatGroupInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatGroupInfo> buildActionHook(DeciTreeOption<MatGroupInfo> option) {
		ActionStdV1<MatGroupInfo> select = new StdMatGroupSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_NOT_FOUND;
	}
}
