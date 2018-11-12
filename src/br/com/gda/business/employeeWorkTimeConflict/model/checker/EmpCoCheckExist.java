package br.com.gda.business.employeeWorkTimeConflict.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.decisionTree.RootEmpCoSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpCoCheckExist extends ModelCheckerTemplateAction<EmpCoInfo> {

	public EmpCoCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpCoInfo> buildActionHook(EmpCoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpCoInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpCoInfo> actionSelect = new RootEmpCoSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpCoInfo> buildOption(EmpCoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpCoInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {
		return SystemMessage.EMP_WTIME_RANGE_CONFLICT;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_RANGE_CONFLICT;
	}
}
