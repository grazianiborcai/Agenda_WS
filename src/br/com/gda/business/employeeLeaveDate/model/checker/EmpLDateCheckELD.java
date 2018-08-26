package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.ActionEmpLDateSelectRange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpLDateCheckELD extends ModelCheckerTemplateAction<EmpLDateInfo> {
	
	public EmpLDateCheckELD(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<EmpLDateInfo> buildActionHook(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpLDateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<EmpLDateInfo> actionSelect = new ActionEmpLDateSelectRange(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpLDateInfo> buildOption(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpLDateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_LDATE_NO_LEAVE_FOUND)
			return SystemMessage.EMP_LDATE_NO_LEAVE_FOUND;
		
		return SystemMessage.EMP_LDATE_LEAVE_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_LDATE_LEAVE_FOUND;	
			
		return SystemCode.EMP_LDATE_NO_LEAVE_FOUND;
	}
}
