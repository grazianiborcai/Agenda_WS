package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.action.StdMatGroupSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatGroupCheckExist extends ModelCheckerTemplateActionV2<MatGroupInfo, MatGroupInfo> {
	
	public MatGroupCheckExist(ModelCheckerOption option) {
		super(option, MatGroupInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatGroupInfo> buildActionHook(DeciTreeOption<MatGroupInfo> option) {
		ActionStd<MatGroupInfo> select = new StdMatGroupSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_NOT_FOUND;
	}
}
