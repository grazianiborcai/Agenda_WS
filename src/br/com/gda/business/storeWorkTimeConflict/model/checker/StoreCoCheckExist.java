package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.decisionTree.RootStoreCoSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCoCheckExist extends ModelCheckerTemplateAction_<StoreCoInfo> {	

	public StoreCoCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoreCoInfo> buildActionHook(StoreCoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreCoInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<StoreCoInfo> actionSelect = new RootStoreCoSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreCoInfo> buildOption(StoreCoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreCoInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {
		return SystemMessage.CONFLICT;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.CONFLICT;
	}
}
