package br.com.gda.business.materialEmployee.model.chekcer;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.decisionTree.ActionMatEmpEnforceDel;
import br.com.gda.business.materialEmployee.model.decisionTree.HandlerMatEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatEmpCheckSoftDelete extends ModelCheckerTemplateSimple<MatEmpInfo> {
	private final boolean ALREADY_EXIST = true;
	private final boolean NOT_FOUND = false;
	private final boolean FAILED = false;
	private final boolean EMPTY_RESULTSET = false;
	
	private DeciAction<MatEmpInfo> actionSelect;
	private DeciResult<MatEmpInfo> actionResult;
	
	
	public MatEmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatEmpInfo recordInfo, Connection conn, String schemaName) {	
		executeAction(recordInfo, conn, schemaName);
		
		if (actionResult.hasSuccessfullyFinished() == FAILED)
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		
		if (actionResult.hasResultset() == EMPTY_RESULTSET)
			return NOT_FOUND;
		
		if (actionResult.getResultset().isEmpty())
			return NOT_FOUND;
		
		return ALREADY_EXIST;
	}
	
	
	
	private void executeAction(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		buildAction(recordInfo, conn, schemaName);
		actionSelect.executeAction();
		actionResult = actionSelect.getDecisionResult();
	}
	
	
	
	private void buildAction(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		actionSelect = new ActionMatEmpEnforceDel(option);
		actionSelect.addPostAction(new HandlerMatEmpSelect(conn, schemaName));
	}
	
	
	
	private DeciTreeOption<MatEmpInfo> buildActionOption(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_MAT_EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MAT_EMP_FLAGGED_AS_DELETED;	
	}
}
