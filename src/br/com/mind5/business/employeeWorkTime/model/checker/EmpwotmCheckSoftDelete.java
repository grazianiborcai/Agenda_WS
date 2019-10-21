package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
