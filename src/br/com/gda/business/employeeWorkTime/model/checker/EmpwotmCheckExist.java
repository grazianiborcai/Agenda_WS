package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class EmpwotmCheckExist extends ModelCheckerTemplateAction<EmpwotmInfo> {
	
	public EmpwotmCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwotmInfo> actionSelect = new StdEmpwotmSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpwotmInfo> buildOption(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_WTIME_ALREADY_EXIST)
			return SystemMessage.EMP_WTIME_ALREADY_EXIST;
		
		return SystemMessage.EMP_WTIME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_WTIME_ALREADY_EXIST;	
			
		return SystemCode.EMP_WTIME_NOT_FOUND;
	}
}
