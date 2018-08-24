package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.ActionEmpWTimeSelectRange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpWTimeCheckEWT extends ModelCheckerTemplateAction<EmpWTimeInfo> {
	
	public EmpWTimeCheckEWT(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<EmpWTimeInfo> buildActionHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpWTimeInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<EmpWTimeInfo> actionSelect = new ActionEmpWTimeSelectRange(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpWTimeInfo> buildOption(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpWTimeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_WTIME_VALID_WORKHOUR)
			return SystemMessage.EMP_WTIME_VALID_WORKHOUR;
		
		return SystemMessage.EMP_WTIME_WORKHOUR_OUT_OF_RANGE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_WTIME_WORKHOUR_OUT_OF_RANGE;	
			
		return SystemCode.EMP_WTIME_NOT_FOUND;
	}
}
