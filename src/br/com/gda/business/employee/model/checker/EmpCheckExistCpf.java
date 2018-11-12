package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.ActionEmpEnforceCpf;
import br.com.gda.business.employee.model.decisionTree.HandlerEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCheckExistCpf extends ModelCheckerTemplateAction<EmpInfo> {
	
	public EmpCheckExistCpf(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> buildActionHook(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpInfo> actionSelect = new ActionEmpEnforceCpf(option);
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_CPF_ALREADY_EXIST)
			return SystemMessage.EMP_CPF_ALREADY_EXIST;
		
		return SystemMessage.EMP_CPF_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_CPF_ALREADY_EXIST;	
			
		return SystemCode.EMP_CPF_NOT_FOUND;
	}
}
