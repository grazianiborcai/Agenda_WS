package br.com.mind5.business.employeeSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.LazyEmpnapSelect;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpnapCheckExist extends ModelCheckerTemplateAction_<EmpnapInfo> {
	
	public EmpnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpnapInfo> buildActionHook(EmpnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpnapInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpnapInfo> actionSelect = new StdEmpnapEnforceKey(option);
		actionSelect.addPostAction(new LazyEmpnapSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpnapInfo> buildOption(EmpnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_SNAP_ALREADY_EXIST)
			return SystemMessage.EMP_SNAP_ALREADY_EXIST;
		
		return SystemMessage.EMP_SNAP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_SNAP_ALREADY_EXIST;	
			
		return SystemCode.EMP_SNAP_NOT_FOUND;
	}
}
