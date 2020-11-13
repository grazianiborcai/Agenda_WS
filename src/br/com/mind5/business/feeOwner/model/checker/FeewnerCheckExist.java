package br.com.mind5.business.feeOwner.model.checker;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerCheckExist extends ModelCheckerTemplateActionV2<FeewnerInfo, FeewnerInfo> {
	
	public FeewnerCheckExist(ModelCheckerOption option) {
		super(option, FeewnerInfo.class);
	}
	

	
	@Override protected ActionStdV2<FeewnerInfo> buildActionHook(DeciTreeOption<FeewnerInfo> option) {
		ActionStdV2<FeewnerInfo> select = new StdFeewnerDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_FEE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FEE_NOT_FOUND;
	}
}
