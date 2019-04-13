package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.LazyEmplevateSelect;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateEnforceEmposKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class EmplevateCheckHasEmposItem extends ModelCheckerTemplateAction<EmplevateInfo> {
	
	public EmplevateCheckHasEmposItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> buildActionHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmplevateInfo> enforceEmposKey = new StdEmplevateEnforceEmposKey(option);
		ActionLazy<EmplevateInfo> select = new LazyEmplevateSelect(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(select);		
		return enforceEmposKey;
	}
	
	
	
	private DeciTreeOption<EmplevateInfo> buildOption(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplevateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_LDATE_ALREADY_EXIST)
			return SystemMessage.EMP_LDATE_ALREADY_EXIST;
		
		return SystemMessage.EMP_LDATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.EMP_LDATE_ALREADY_EXIST;	
			
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
