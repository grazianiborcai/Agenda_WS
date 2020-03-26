package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerSelect;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerCheckExist extends ModelCheckerTemplateAction<OwnerInfo, OwnerInfo> {
	
	public OwnerCheckExist(ModelCheckerOption option) {
		super(option, OwnerInfo.class);
	}
	
	
	
	@Override protected ActionStd<OwnerInfo> buildActionHook(DeciTreeOption<OwnerInfo> option) {
		ActionStd<OwnerInfo> enforceKey = new StdOwnerEnforceKey(option);
		ActionLazy<OwnerInfo> select = new LazyOwnerSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);		
		return enforceKey;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OWNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_NOT_FOUND;
	}
}
