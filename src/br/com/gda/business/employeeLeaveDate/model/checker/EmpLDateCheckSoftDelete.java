package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.ActionEmpLDateEnforceDel;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.HandlerEmpLDateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpLDateCheckSoftDelete extends ModelCheckerTemplateAction<EmpLDateInfo> {	
	
	public EmpLDateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpLDateInfo> buildActionHook(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpLDateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpLDateInfo> actionSelect = new ActionEmpLDateEnforceDel(option);
		actionSelect.addPostAction(new HandlerEmpLDateSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpLDateInfo> buildActionOption(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpLDateInfo> option = new DeciTreeOption<>();
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
