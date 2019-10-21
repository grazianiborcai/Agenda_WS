package br.com.mind5.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceStoreKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckHasItem_ extends ModelCheckerTemplateAction_<StowotmInfo> {
	
	public StowotmCheckHasItem_(ModelCheckerOption option) {
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
