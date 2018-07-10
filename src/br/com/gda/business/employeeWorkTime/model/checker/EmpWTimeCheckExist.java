package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.ActionEmpWTimeSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class EmpWTimeCheckExist extends ModelCheckerTemplateAction<EmpWTimeInfo> {
	
	public EmpWTimeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<EmpWTimeInfo> buildActionHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpWTimeInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<EmpWTimeInfo> actionSelect = new ActionEmpWTimeSelect(option);
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
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_WTIME_ALREADY_EXIST)
			return SystemMessage.EMP_WTIME_ALREALDY_EXIST;
		
		return SystemMessage.EMP_WTIME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_WTIME_ALREADY_EXIST;	
			
		return SystemCode.EMP_WTIME_NOT_FOUND;
	}
}
