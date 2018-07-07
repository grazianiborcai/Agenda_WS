package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.decisionTree.RootEmpCoSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpWTimeCheckHasCo extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean NO_CONFLICT = false;
	private final boolean HAS_CONFLICT = true;
	
	private String failureMsg;
	private int failureCode;
	

	public EmpWTimeCheckHasCo(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTree<EmpCoInfo> storeCoSelect = new RootEmpCoSelect(buildTreeOption(recordInfo, conn, schemaName));
		storeCoSelect.makeDecision();

		if (storeCoSelect.getDecisionResult().hasSuccessfullyFinished() == HAS_CONFLICT) {
			buildFailureOutput();
			return HAS_CONFLICT;
		}
		
		
		return NO_CONFLICT;
	}
	
	
	
	private DeciTreeOption<EmpCoInfo> buildTreeOption(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {		
		DeciTreeOption<EmpCoInfo> option = new DeciTreeOption<>();
		
		List<EmpCoInfo> recordInfos = new ArrayList<>();
		recordInfos.add(EmpCoInfo.copyFrom(recordInfo));
		option.recordInfos = recordInfos;
		
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	private void buildFailureOutput() {
		failureMsg = SystemMessage.EMP_WTIME_RANGE_CONFLICT;
		failureCode = SystemCode.EMP_WTIME_RANGE_CONFLICT;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return failureMsg;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failureCode;
	}
}
