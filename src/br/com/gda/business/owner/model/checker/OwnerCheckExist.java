package br.com.gda.business.owner.model.checker;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.StdOwnerEnforceKey;
import br.com.gda.business.owner.model.action.LazyOwnerSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwnerCheckExist extends ModelCheckerTemplateActionV2<OwnerInfo, OwnerInfo> {
	
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
