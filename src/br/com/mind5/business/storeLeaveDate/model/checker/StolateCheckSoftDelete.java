package br.com.mind5.business.storeLeaveDate.model.checker;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateDaoSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckSoftDelete extends ModelCheckerTemplateAction<StolateInfo, StolateInfo> {
	
	public StolateCheckSoftDelete(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStd<StolateInfo> enforceDel = new StdStolateEnforceDel(option);
		ActionLazy<StolateInfo> selectKey = new LazyStolateDaoSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(selectKey);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;
	}
}
