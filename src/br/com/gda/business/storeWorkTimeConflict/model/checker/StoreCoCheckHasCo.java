package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.decisionTree.ActionStoreCoMakeRange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCoCheckHasCo implements ModelChecker<StoreCoInfo> {
	private final boolean RESULT_FAILED = false;	
	private final boolean RESULT_SUCCESS = true;
	private final boolean NO_RESULTSET = false;
	
	private DeciAction<StoreCoInfo> actionRange;
	private Connection conn;
	private boolean expectedResult;
	private String schemaName;
	private boolean checkerResult;
	private int checkerFailureCode;
	private String checkerFailureExplanation;
	
	
	public StoreCoCheckHasCo(ModelCheckerOption option) {
		checkArgument(option);
		
		conn = option.conn;
		schemaName = option.schemaName;
		expectedResult = option.expectedResult;
	}
	
	
	
	private void checkArgument(ModelCheckerOption option) {
		if (option == null)
			throw new NullPointerException("option " + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("option.conn " + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("option.schemaName " + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public boolean check(StoreCoInfo recordInfo) {
		List<StoreCoInfo> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);		
		return check(recordInfos);
	}
	
	
	
	@Override public boolean check(List<StoreCoInfo> recordInfos) {
		actionRange = new ActionStoreCoMakeRange(buildActionOption(recordInfos));
		actionRange.executeAction();
		buildResult();
		return checkerResult;
	}
	
	
	
	private DeciTreeOption<StoreCoInfo> buildActionOption(List<StoreCoInfo> recordInfos) {
		DeciTreeOption<StoreCoInfo> actionOption = new DeciTreeOption<>();
		actionOption.recordInfos = recordInfos;
		actionOption.conn = conn;
		actionOption.schemaName = schemaName;
		return actionOption;
	}
	
	
	
	private void buildResult() {
		boolean parcialResult;
		
		checkerFailureExplanation = SystemMessage.CONFLICT;
		checkerFailureCode = SystemCode.CONFLICT;
		parcialResult = RESULT_SUCCESS;
		
		parcialResult = buildResultFromAction();
		
		
		if (expectedResult == parcialResult) {
			checkerResult = RESULT_SUCCESS;
		} else {
			checkerResult = RESULT_FAILED;
		}
	}
	
	
	
	private boolean buildResultFromAction() {
		DeciResult<StoreCoInfo> actionResult = actionRange.getDecisionResult();
		
		if (actionResult.hasSuccessfullyFinished() == RESULT_FAILED) {
			checkerFailureExplanation = actionResult.getFailureMessage();
			checkerFailureCode = actionResult.getFailureCode();
			return RESULT_FAILED;
		}
		
		
		if (actionResult.hasResultset() == NO_RESULTSET) {
			checkerFailureExplanation = SystemMessage.NO_CONFLICT;
			checkerFailureCode = SystemCode.NO_CONFLICT;
			return RESULT_FAILED;
		}
		
		
		List<StoreCoInfo> resultset = actionResult.getResultset();
		
		if (resultset == null || resultset.isEmpty()) {
			checkerFailureExplanation = SystemMessage.NO_CONFLICT;
			checkerFailureCode = SystemCode.NO_CONFLICT;
			return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean getResult() {
		if (this.actionRange == null)
			throw new IllegalStateException(SystemMessage.NO_CHECK_PERFORMED);
		
		return checkerResult;
	}

	
	
	@Override public String getFailureExplanation() {
		if (getResult() == RESULT_SUCCESS)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return checkerFailureExplanation;
	}

	
	
	@Override public int getFailureCode() {
		if (getResult() == RESULT_SUCCESS)
			throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
		
		return checkerFailureCode;
	}
}
