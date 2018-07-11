package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.ActionStoreWTimeSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreWTimeCheckExist extends ModelCheckerTemplateAction<StoreWTimeInfo> {
	
	public StoreWTimeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreWTimeInfo> buildActionHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreWTimeInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreWTimeInfo> actionSelect = new ActionStoreWTimeSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreWTimeInfo> buildOption(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreWTimeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_WTIME_ALREADY_EXIST)
			return SystemMessage.STORE_WTIME_ALREADY_EXIST;
		
		return SystemMessage.STORE_WTIME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_WTIME_ALREADY_EXIST;	
			
		return SystemCode.STORE_WTIME_NOT_FOUND;
	}
}
