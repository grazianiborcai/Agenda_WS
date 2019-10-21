package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplevateCheckSoftDelete extends ModelCheckerTemplateAction_<EmplevateInfo> {	
	
	public EmplevateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> buildActionHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmplevateInfo> actionSelect = new StdEmplevateEnforceDel(option);
		actionSelect.addPostAction(new LazyEmplevateSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmplevateInfo> buildActionOption(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_LDATE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMP_LDATE_FLAGGED_AS_DELETED;	
	}
}
