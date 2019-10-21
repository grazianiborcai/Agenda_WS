package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckExist extends ModelCheckerTemplateAction_<EmpmatInfo> {
	
	public EmpmatCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpmatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpmatInfo> actionSelect = new StdEmpmatSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpmatInfo> buildOption(EmpmatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpmatInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_MAT_EMP_ALREADY_EXIST)
			return SystemMessage.STORE_MAT_EMP_ALREADY_EXIST;
		
		return SystemMessage.STORE_MAT_EMP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_MAT_EMP_ALREADY_EXIST;	
			
		return SystemCode.STORE_MAT_EMP_NOT_FOUND;
	}
}
