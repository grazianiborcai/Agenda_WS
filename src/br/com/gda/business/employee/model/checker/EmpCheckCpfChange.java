package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.ActionEmpEnforceKeyCpf;
import br.com.gda.business.employee.model.decisionTree.HandlerEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCheckCpfChange extends ModelCheckerTemplate<EmpInfo> {
	private final boolean ALREADY_EXIST = true;
	private final boolean NOT_FOUND = false;
	private final boolean FAILED = false;
	private final boolean EMPTY_RESULTSET = false;
	
	private DeciAction<EmpInfo> actionSelect;
	private DeciResult<EmpInfo> actionResult;
	
	
	public EmpCheckCpfChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		executeAction(recordInfo, conn, schemaName);
		
		if (actionResult.hasSuccessfullyFinished() == FAILED)
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		
		if (actionResult.hasResultset() == EMPTY_RESULTSET)
			return NOT_FOUND;
		
		if (actionResult.getResultset().isEmpty())
			return NOT_FOUND;
		
		return ALREADY_EXIST;
	}
	
	
	
	private void executeAction(EmpInfo recordInfo, Connection conn, String schemaName) {
		buildAction(recordInfo, conn, schemaName);
		actionSelect.executeAction();
		actionResult = actionSelect.getDecisionResult();
	}
	
	
	
	private void buildAction(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		actionSelect = new ActionEmpEnforceKeyCpf(option);
		actionSelect.addPostAction(new HandlerEmpSelect(conn, schemaName));
	}
	
	
	
	private DeciTreeOption<EmpInfo> buildActionOption(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_ALREADY_EXIST)
			return SystemMessage.EMP_ALREALDY_EXIST;
		
		return SystemMessage.EMP_DATA_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_ALREADY_EXIST;	
			
		return SystemCode.EMP_NOT_FOUND;
	}
}
