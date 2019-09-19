package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmEnforceDel;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckSoftDelete extends ModelCheckerTemplateAction_<EmpwotmInfo> {
	
	public EmpwotmCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwotmInfo> actionSelect = new StdEmpwotmEnforceDel(option);
		actionSelect.addPostAction(new LazyEmpwotmSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpwotmInfo> buildActionOption(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_WTIME_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_FLAGGED_AS_DELETED;	
	}
}
