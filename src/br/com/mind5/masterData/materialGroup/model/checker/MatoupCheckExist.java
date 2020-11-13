package br.com.mind5.masterData.materialGroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.StdMatoupDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupCheckExist extends ModelCheckerTemplateAction<MatoupInfo, MatoupInfo> {
	
	public MatoupCheckExist(ModelCheckerOption option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoupInfo> buildActionHook(DeciTreeOption<MatoupInfo> option) {
		ActionStd<MatoupInfo> select = new StdMatoupDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_NOT_FOUND;
	}
}
