package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.decisionTree.RootStoreCoSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class StoreWTimeCheckHasCo extends ModelCheckerTemplateSimple<StoreWTimeInfo> {
	private final boolean NO_CONFLICT = false;
	private final boolean HAS_CONFLICT = true;
	
	private String failureMsg;
	private int failureCode;
	

	public StoreWTimeCheckHasCo(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTree<StoreCoInfo> storeCoSelect = new RootStoreCoSelect(buildTreeOption(recordInfo, conn, schemaName));
		storeCoSelect.makeDecision();

		if (storeCoSelect.getDecisionResult().hasSuccessfullyFinished() == HAS_CONFLICT) {
			buildFailureOutput();
			return HAS_CONFLICT;
		}
		
		
		return NO_CONFLICT;
	}
	
	
	
	private DeciTreeOption<StoreCoInfo> buildTreeOption(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {		
		DeciTreeOption<StoreCoInfo> option = new DeciTreeOption<>();
		
		List<StoreCoInfo> recordInfos = new ArrayList<>();
		recordInfos.add(StoreCoInfo.copyFrom(recordInfo));
		option.recordInfos = recordInfos;
		
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	private void buildFailureOutput() {
		failureMsg = SystemMessage.CONFLICT;
		failureCode = SystemCode.CONFLICT;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return failureMsg;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failureCode;
	}
}
