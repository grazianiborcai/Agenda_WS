package br.com.mind5.business.materialTextDefault.model.checker;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.action.StdMatextaultDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextaultCheckExist extends ModelCheckerTemplateActionV2<MatextaultInfo, MatextaultInfo> {
	
	public MatextaultCheckExist(ModelCheckerOption option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatextaultInfo> buildActionHook(DeciTreeOption<MatextaultInfo> option) {
		ActionStdV1<MatextaultInfo> select = new StdMatextaultDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_DEFAULT_NOT_FOUND;
	}
}
