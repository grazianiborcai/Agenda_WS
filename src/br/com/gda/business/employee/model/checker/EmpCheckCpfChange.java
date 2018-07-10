package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.ActionEmpEnforceKeyCpf;
import br.com.gda.business.employee.model.decisionTree.HandlerEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCheckCpfChange extends ModelCheckerTemplateAction<EmpInfo> {
	
	public EmpCheckCpfChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<EmpInfo> buildActionHook(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<EmpInfo> actionSelect = new ActionEmpEnforceKeyCpf(option);
		actionSelect.addPostAction(new HandlerEmpSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpInfo> buildOption(EmpInfo recordInfo, Connection conn, String schemaName) {
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
