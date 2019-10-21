package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpSelect;
import br.com.mind5.business.employee.model.action.StdEmpEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpCheckExist extends ModelCheckerTemplateAction_<EmpInfo> {
	
	public EmpCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> buildActionHook(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpInfo> actionSelect = new StdEmpEnforceKey(option);
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
			return SystemMessage.EMP_ALREADY_EXIST;
		
		return SystemMessage.EMP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_ALREADY_EXIST;	
			
		return SystemCode.EMP_NOT_FOUND;
	}
}
