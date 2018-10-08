package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.ActionEmpWTimeEnforceDel;
import br.com.gda.business.employeeWorkTime.model.decisionTree.HandlerEmpWTimeSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpWTimeCheckSoftDelete extends ModelCheckerTemplateAction<EmpWTimeInfo> {
	
	public EmpWTimeCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpWTimeInfo> buildActionHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpWTimeInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpWTimeInfo> actionSelect = new ActionEmpWTimeEnforceDel(option);
		actionSelect.addPostAction(new HandlerEmpWTimeSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpWTimeInfo> buildActionOption(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpWTimeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_WTIME_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_FLAGGED_AS_DELETED;	
	}
}
