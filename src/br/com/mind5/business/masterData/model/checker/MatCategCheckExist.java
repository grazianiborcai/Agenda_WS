package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.action.StdMatCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCategCheckExist extends ModelCheckerTemplateActionV2<MatCategInfo, MatCategInfo> {
	
	public MatCategCheckExist(ModelCheckerOption option) {
		super(option, MatCategInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatCategInfo> buildActionHook(DeciTreeOption<MatCategInfo> option) {
		ActionStdV1<MatCategInfo> select = new StdMatCategSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
