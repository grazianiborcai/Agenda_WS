package br.com.mind5.masterData.materialGroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.StdMatoupDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupCheckExist extends ModelCheckerTemplateActionV2<MatoupInfo, MatoupInfo> {
	
	public MatoupCheckExist(ModelCheckerOption option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatoupInfo> buildActionHook(DeciTreeOption<MatoupInfo> option) {
		ActionStdV2<MatoupInfo> select = new StdMatoupDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_NOT_FOUND;
	}
}
