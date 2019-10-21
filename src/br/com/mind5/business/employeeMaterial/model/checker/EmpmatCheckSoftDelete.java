package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckSoftDelete extends ModelCheckerTemplateAction_<EmpmatInfo> {	
	
	public EmpmatCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpmatInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpmatInfo> actionSelect = new StdEmpmatEnforceDel(option);
		actionSelect.addPostAction(new LazyEmpmatSelect(conn, schemaName));
		return actionSelect ;
	}
	
	
	
	private DeciTreeOption<EmpmatInfo> buildActionOption(EmpmatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpmatInfo> option = new DeciTreeOption<>();
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
