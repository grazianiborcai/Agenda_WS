package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.action.StdMatCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCategCheckExist extends ModelCheckerTemplateAction<MatCategInfo, MatCategInfo> {
	
	public MatCategCheckExist(ModelCheckerOption option) {
		super(option, MatCategInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatCategInfo> buildActionHook(DeciTreeOption<MatCategInfo> option) {
		ActionStd<MatCategInfo> select = new StdMatCategSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
