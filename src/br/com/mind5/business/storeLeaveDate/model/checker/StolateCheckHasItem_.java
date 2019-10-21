package br.com.mind5.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateRootSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateEnforceStoreKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckHasItem_ extends ModelCheckerTemplateAction_<StolateInfo> {
	
	public StolateCheckHasItem_(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<StolateInfo> buildActionHook(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StolateInfo> enforceStoreKey = new StdStolateEnforceStoreKey(option);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(conn, schemaName);		
		
		enforceStoreKey.addPostAction(select);
		
		return enforceStoreKey;
	}
	
	
	
	private DeciTreeOption<StolateInfo> buildActionOption(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_LDATE_HAVE_ITEM)
			return SystemMessage.STORE_LDATE_HAVE_ITEM;
		
		return SystemMessage.STORE_LDATE_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STORE_LDATE_HAVE_ITEM;	
		
		return SystemCode.STORE_LDATE_IS_EMPTY;
	}
}
