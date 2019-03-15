package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateRootSelect;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateEnforceStoreKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolevateCheckHasItem extends ModelCheckerTemplateAction<StolevateInfo> {
	
	public StolevateCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<StolevateInfo> buildActionHook(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StolevateInfo> enforceStoreKey = new StdStolevateEnforceStoreKey(option);
		ActionLazy<StolevateInfo> select = new LazyStolevateRootSelect(conn, schemaName);		
		
		enforceStoreKey.addPostAction(select);
		
		return enforceStoreKey;
	}
	
	
	
	private DeciTreeOption<StolevateInfo> buildActionOption(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = new DeciTreeOption<>();
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
