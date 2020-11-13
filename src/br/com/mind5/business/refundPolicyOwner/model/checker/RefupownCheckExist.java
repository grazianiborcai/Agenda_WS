package br.com.mind5.business.refundPolicyOwner.model.checker;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownCheckExist extends ModelCheckerTemplateAction<RefupownInfo, RefupownInfo> {
	
	public RefupownCheckExist(ModelCheckerOption option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefupownInfo> buildActionHook(DeciTreeOption<RefupownInfo> option) {
		ActionStd<RefupownInfo> select = new StdRefupownDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_OWNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_OWNER_NOT_FOUND;
	}
}
