package br.com.gda.business.materialEmployee.model.chekcer;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.decisionTree.ActionMatEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatEmpCheckExist extends ModelCheckerTemplateAction<MatEmpInfo> {
	
	public MatEmpCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatEmpInfo> buildActionHook(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatEmpInfo> actionSelect = new ActionMatEmpSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatEmpInfo> buildOption(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_MAT_EMP_ALREADY_EXIST)
			return SystemMessage.STORE_MAT_EMP_ALREADY_EXIST;
		
		return SystemMessage.STORE_MAT_EMP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_MAT_EMP_ALREADY_EXIST;	
			
		return SystemCode.STORE_MAT_EMP_NOT_FOUND;
	}
}
