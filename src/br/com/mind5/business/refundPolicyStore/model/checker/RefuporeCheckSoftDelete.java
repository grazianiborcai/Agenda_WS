package br.com.mind5.business.refundPolicyStore.model.checker;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeDaoSelect;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeCheckSoftDelete extends ModelCheckerTemplateAction<RefuporeInfo, RefuporeInfo> {
	
	public RefuporeCheckSoftDelete(ModelCheckerOption option) {
		super(option, RefuporeInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefuporeInfo> buildActionHook(DeciTreeOption<RefuporeInfo> option) {
		ActionStd<RefuporeInfo> enforceDel = new StdRefuporeEnforceDel(option);
		ActionLazy<RefuporeInfo> select = new LazyRefuporeDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_STORE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_NOT_FLAGGED_AS_DELETED;
	}
}
