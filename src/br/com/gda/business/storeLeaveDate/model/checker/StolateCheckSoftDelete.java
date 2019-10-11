package br.com.gda.business.storeLeaveDate.model.checker;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceDel;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateCheckSoftDelete extends ModelCheckerTemplateActionV2<StolateInfo, StolateInfo> {
	
	public StolateCheckSoftDelete(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStd<StolateInfo> enforceDel = new StdStolateEnforceDel(option);
		ActionLazy<StolateInfo> selectKey = new LazyStolateSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(selectKey);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;
	}
}
