package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.action.StdFeeCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeeCategCheckExist extends ModelCheckerTemplateActionV2<FeeCategInfo, FeeCategInfo> {
	
	public FeeCategCheckExist(ModelCheckerOption option) {
		super(option, FeeCategInfo.class);
	}
	
	
	
	@Override protected ActionStd<FeeCategInfo> buildActionHook(DeciTreeOption<FeeCategInfo> option) {
		ActionStd<FeeCategInfo> select = new StdFeeCategSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FEE_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_CATEG_NOT_FOUND;
	}
}
