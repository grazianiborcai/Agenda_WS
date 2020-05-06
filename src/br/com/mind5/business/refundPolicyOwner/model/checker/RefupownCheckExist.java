package br.com.mind5.business.refundPolicyOwner.model.checker;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownCheckExist extends ModelCheckerTemplateActionV2<RefupownInfo, RefupownInfo> {
	
	public RefupownCheckExist(ModelCheckerOption option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefupownInfo> buildActionHook(DeciTreeOption<RefupownInfo> option) {
		ActionStdV1<RefupownInfo> select = new StdRefupownDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUND_POL_OWNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_POL_OWNER_NOT_FOUND;
	}
}
