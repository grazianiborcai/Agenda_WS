package br.com.gda.business.materialEmployee.model.chekcer;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.decisionTree.ActionMatEmpEnforceDel;
import br.com.gda.business.materialEmployee.model.decisionTree.HandlerMatEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatEmpCheckSoftDelete extends ModelCheckerTemplateAction<MatEmpInfo> {	
	
	public MatEmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatEmpInfo> buildActionHook(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatEmpInfo> actionSelect = new ActionMatEmpEnforceDel(option);
		actionSelect.addPostAction(new HandlerMatEmpSelect(conn, schemaName));
		return actionSelect ;
	}
	
	
	
	private DeciTreeOption<MatEmpInfo> buildActionOption(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatEmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_MAT_EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MAT_EMP_FLAGGED_AS_DELETED;	
	}
}
