package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.ActionStoreWTimeEnforceDel;
import br.com.gda.business.storeWorkTime.model.decisionTree.HandlerStoreWTimeSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreWTimeCheckSoftDelete extends ModelCheckerTemplateAction<StoreWTimeInfo> {

	public StoreWTimeCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreWTimeInfo> buildActionHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreWTimeInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreWTimeInfo> actionSelect = new ActionStoreWTimeEnforceDel(option);
		actionSelect.addPostAction(new HandlerStoreWTimeSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreWTimeInfo> buildActionOption(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreWTimeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_WTIME_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_WTIME_FLAGGED_AS_DELETED;	
	}
}
