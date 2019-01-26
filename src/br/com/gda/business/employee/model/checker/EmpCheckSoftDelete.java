package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.StdEmpEnforceDel;
import br.com.gda.business.employee.model.action.LazyEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCheckSoftDelete extends ModelCheckerTemplateAction<EmpInfo> {	
	
	public EmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> buildActionHook(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpInfo> actionSelect = new StdEmpEnforceDel(option);
		actionSelect.addPostAction(new LazyEmpSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpInfo> buildActionOption(EmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMP_FLAGGED_AS_DELETED;	
	}
}
