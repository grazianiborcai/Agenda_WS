package br.com.mind5.business.storeLeaveDate.model.checker;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateDaoSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckSoftDelete extends ModelCheckerTemplateActionV2<StolateInfo, StolateInfo> {
	
	public StolateCheckSoftDelete(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStdV1<StolateInfo> enforceDel = new StdStolateEnforceDel(option);
		ActionLazyV1<StolateInfo> selectKey = new LazyStolateDaoSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(selectKey);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;
	}
}
