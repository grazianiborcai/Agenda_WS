package br.com.gda.business.employeeWorkTimeOutlier.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwoutCheckExist extends ModelCheckerTemplateAction_<EmpwoutInfo> {	

	public EmpwoutCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwoutInfo> buildActionHook(EmpwoutInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwoutInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwoutInfo> actionSelect = new RootEmpwoutSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpwoutInfo> buildOption(EmpwoutInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwoutInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {
		return SystemMessage.CONFLICT;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.CONFLICT;
	}
}
