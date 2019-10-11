package br.com.gda.business.storeLeaveDate.model.checker;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateSelect;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateCheckExist extends ModelCheckerTemplateActionV2<StolateInfo, StolateInfo> {
	
	public StolateCheckExist(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStd<StolateInfo> enforceKey = new StdStolateEnforceKey(option);
		ActionLazy<StolateInfo> select = new LazyStolateSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);		
		return enforceKey;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_NOT_FOUND;
	}
}
