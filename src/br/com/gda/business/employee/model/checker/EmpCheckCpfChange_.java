package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.StdEmpEnforceKeyCpf;
import br.com.gda.business.employee.model.action.LazyEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCheckCpfChange_ extends ModelCheckerTemplateAction<EmpInfo> {
	
	public EmpCheckCpfChange_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> buildActionHook(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpInfo> actionSelect = new StdEmpEnforceKeyCpf(option);
		actionSelect.addPostAction(new LazyEmpSelect(conn, schemaName));
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_ALREADY_EXIST)
			return SystemMessage.EMP_ALREALDY_EXIST;
		
		return SystemMessage.EMP_DATA_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_ALREADY_EXIST;	
			
		return SystemCode.EMP_NOT_FOUND;
	}
}
