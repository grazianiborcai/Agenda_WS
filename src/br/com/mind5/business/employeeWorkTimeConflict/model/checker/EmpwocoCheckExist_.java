package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwocoCheckExist_ extends ModelCheckerTemplateAction_<EmpwocoInfo> {

	public EmpwocoCheckExist_(ModelCheckerOption option) {
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
