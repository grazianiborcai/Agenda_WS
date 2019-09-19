package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateSelectRange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmplevateCheckELD extends ModelCheckerTemplateAction_<EmplevateInfo> {
	
	public EmplevateCheckELD(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> buildActionHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmplevateInfo> actionSelect = new StdEmplevateSelectRange(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmplevateInfo> buildOption(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_LDATE_NO_LEAVE_FOUND)
			return SystemMessage.EMP_LDATE_NO_LEAVE_FOUND;
		
		return SystemMessage.EMP_LDATE_LEAVE_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_LDATE_LEAVE_FOUND;	
			
		return SystemCode.EMP_LDATE_NO_LEAVE_FOUND;
	}
}
