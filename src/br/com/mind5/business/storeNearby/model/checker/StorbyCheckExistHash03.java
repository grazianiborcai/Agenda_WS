package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyDaoSelect;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceHash03Key;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyCheckExistHash03 extends ModelCheckerTemplateActionV2<StorbyInfo, StorbyInfo> {
	
	public StorbyCheckExistHash03(ModelCheckerOption option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StorbyInfo> buildActionHook(DeciTreeOption<StorbyInfo> option) {
		ActionStdV1<StorbyInfo> enforceHash = new StdStorbyEnforceHash03Key(option);
		ActionLazyV1<StorbyInfo> select = new LazyStorbyDaoSelect(option.conn, option.schemaName);
		
		enforceHash.addPostAction(select);
		return enforceHash;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_NOT_FOUND;
	}
}
