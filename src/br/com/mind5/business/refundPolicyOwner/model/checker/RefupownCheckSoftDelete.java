package br.com.mind5.business.refundPolicyOwner.model.checker;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownDaoSelect;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownCheckSoftDelete extends ModelCheckerTemplateAction<RefupownInfo, RefupownInfo> {
	
	public RefupownCheckSoftDelete(ModelCheckerOption option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefupownInfo> buildActionHook(DeciTreeOption<RefupownInfo> option) {
		ActionStd<RefupownInfo> enforceDel = new StdRefupownEnforceDel(option);
		ActionLazy<RefupownInfo> select = new LazyRefupownDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_OWNER_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_OWNER_NOT_FLAGGED_AS_DELETED;
	}
}
