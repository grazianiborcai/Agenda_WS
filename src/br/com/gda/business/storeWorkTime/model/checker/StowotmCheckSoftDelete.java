package br.com.gda.business.storeWorkTime.model.checker;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmSelect;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceDel;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StowotmCheckSoftDelete extends ModelCheckerTemplateActionV2<StowotmInfo, StowotmInfo> {

	public StowotmCheckSoftDelete(ModelCheckerOption option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> buildActionHook(DeciTreeOption<StowotmInfo> option) {
		ActionStd<StowotmInfo> enforceDel = new StdStowotmEnforceDel(option);
		ActionLazy<StowotmInfo> select = new LazyStowotmSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_FLAGGED_AS_DELETED;	
	}
}
