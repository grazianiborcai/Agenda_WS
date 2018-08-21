package br.com.gda.business.storeEmployee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.decisionTree.ActionStoreEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreEmpCheckExist extends ModelCheckerTemplateAction<StoreEmpInfo> {
	
	public StoreEmpCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreEmpInfo> buildActionHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreEmpInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreEmpInfo> actionSelect = new ActionStoreEmpSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreEmpInfo> buildOption(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreEmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_EMP_ALREADY_EXIST)
			return SystemMessage.STORE_EMP_ALREADY_EXIST;
		
		return SystemMessage.STORE_EMP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_EMP_ALREADY_EXIST;	
			
		return SystemCode.STORE_EMP_NOT_FOUND;
	}
}
