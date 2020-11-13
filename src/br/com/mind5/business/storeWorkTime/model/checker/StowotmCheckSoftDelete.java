package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmDaoSelect;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckSoftDelete extends ModelCheckerTemplateActionV2<StowotmInfo, StowotmInfo> {

	public StowotmCheckSoftDelete(ModelCheckerOption option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StowotmInfo> buildActionHook(DeciTreeOption<StowotmInfo> option) {
		ActionStdV2<StowotmInfo> enforceDel = new StdStowotmEnforceDel(option);
		ActionLazy<StowotmInfo> select = new LazyStowotmDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_FLAGGED_AS_DELETED;	
	}
}
