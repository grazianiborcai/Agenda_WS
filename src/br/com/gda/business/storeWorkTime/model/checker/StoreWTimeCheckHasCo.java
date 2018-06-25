package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.decisionTree.RootStoreCoSelect;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class StoreWTimeCheckHasCo extends ModelCheckerTemplate<StoreWTimeInfo> {
	private DeciResult<StoreCoInfo> deciResult;

	public StoreWTimeCheckHasCo(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTree<StoreCoInfo> storeCoSelect = new RootStoreCoSelect(buildTreeOption(recordInfo, conn, schemaName));
		storeCoSelect.makeDecision();
		deciResult = storeCoSelect.getDecisionResult();
		return deciResult.hasSuccessfullyFinished();
	}
	
	
	
	private DeciTreeOption<StoreCoInfo> buildTreeOption(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {		
		DeciTreeOption<StoreCoInfo> option = new DeciTreeOption<>();
		
		List<StoreCoInfo> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo.toStoreCoInfo());
		option.recordInfos = recordInfos;
		
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return deciResult.getFailureMessage();
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return deciResult.getFailureCode();
	}
}
