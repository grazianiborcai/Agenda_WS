package br.com.mind5.business.feeOwner.model.checker;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.FeewnerVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerCheckExist extends ModelCheckerTemplateAction<FeewnerInfo, FeewnerInfo> {
	
	public FeewnerCheckExist(ModelCheckerOption option) {
		super(option, FeewnerInfo.class);
	}
	

	
	@Override protected ActionStd<FeewnerInfo> buildActionHook(DeciTreeOption<FeewnerInfo> option) {
		ActionStd<FeewnerInfo> select = new ActionStdCommom<FeewnerInfo>(option, FeewnerVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_FEE_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FEE_NOT_FOUND;
	}
}
