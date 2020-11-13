package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.StdMatDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCheckExist extends ModelCheckerTemplateActionV2<MatInfo, MatInfo> {	
	
	public MatCheckExist(ModelCheckerOption option) {
		super(option, MatInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatInfo> buildActionHook(DeciTreeOption<MatInfo> option) {
		ActionStdV2<MatInfo> select = new StdMatDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_NOT_FOUND;
	}
}
