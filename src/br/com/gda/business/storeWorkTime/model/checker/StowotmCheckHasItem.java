package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceStoreKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StowotmCheckHasItem extends ModelCheckerTemplateAction<StowotmInfo> {
	
	public StowotmCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<StowotmInfo> buildActionHook(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StowotmInfo> enforceStoreKey = new StdStowotmEnforceStoreKey(option);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(conn, schemaName);		
		
		enforceStoreKey.addPostAction(select);
		
		return enforceStoreKey;
	}
	
	
	
	private DeciTreeOption<StowotmInfo> buildActionOption(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_WTIME_HAVE_ITEM)
			return SystemMessage.STORE_WTIME_HAVE_ITEM;
		
		return SystemMessage.STORE_WTIME_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STORE_WTIME_HAVE_ITEM;	
		
		return SystemCode.STORE_WTIME_IS_EMPTY;
	}
}
