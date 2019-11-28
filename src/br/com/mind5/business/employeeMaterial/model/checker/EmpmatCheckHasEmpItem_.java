package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceEmpKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckHasEmpItem_ extends ModelCheckerTemplateAction_<EmpmatInfo> {	
	
	public EmpmatCheckHasEmpItem_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpmatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmpmatInfo> actionSelect = new StdEmpmatEnforceEmpKey(option);
		actionSelect.addPostAction(new LazyEmpmatSelect(conn, schemaName));
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
		if (makeFailCodeHook(checkerResult) == SystemCode.EMPOS_HAS_ITEM)
			return SystemMessage.EMPOS_HAS_ITEM;
		
		return SystemMessage.EMPOS_NO_ITEM_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.EMPOS_HAS_ITEM;	
			
		return SystemCode.EMPOS_NO_ITEM_FOUND;
	}
}
