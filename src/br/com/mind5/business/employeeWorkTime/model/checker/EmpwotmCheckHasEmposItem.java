package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceEmposKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class EmpwotmCheckHasEmposItem extends ModelCheckerTemplateAction_<EmpwotmInfo> {
	
	public EmpwotmCheckHasEmposItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpwotmInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpwotmInfo> enforceEmposKey = new StdEmpwotmEnforceEmposKey(option);
		ActionLazy<EmpwotmInfo> select = new LazyEmpwotmSelect(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(select);		
		return enforceEmposKey;
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
