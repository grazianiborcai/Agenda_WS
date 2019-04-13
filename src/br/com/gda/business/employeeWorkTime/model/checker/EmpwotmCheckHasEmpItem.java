package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmSelect;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmEnforceEmpKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class EmpwotmCheckHasEmpItem extends ModelCheckerTemplateAction<EmpwotmInfo> {
	
	public EmpwotmCheckHasEmpItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwotmInfo> enforceEmpKey = new StdEmpwotmEnforceEmpKey(option);
		ActionLazy<EmpwotmInfo> select = new LazyEmpwotmSelect(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(select);		
		return enforceEmpKey;
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
