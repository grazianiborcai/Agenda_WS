package br.com.gda.business.employeeWorkTimeConflict.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwocoCheckExist extends ModelCheckerTemplateAction<EmpwocoInfo> {

	public EmpwocoCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwocoInfo> buildActionHook(EmpwocoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwocoInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwocoInfo> actionSelect = new RootEmpwocoSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpwocoInfo> buildOption(EmpwocoInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwocoInfo> option = new DeciTreeOption<>();
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
