package br.com.gda.business.storeEmployee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.decisionTree.ActionStoreEmpEnforceDel;
import br.com.gda.business.storeEmployee.model.decisionTree.HandlerStoreEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreEmpCheckSoftDelete extends ModelCheckerTemplateAction<StoreEmpInfo> {
	
	public StoreEmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreEmpInfo> buildActionHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreEmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreEmpInfo> actionSelect = new ActionStoreEmpEnforceDel(option);
		actionSelect.addPostAction(new HandlerStoreEmpSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreEmpInfo> buildActionOption(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreEmpInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_EMP_FLAGGED_AS_DELETED;	
	}
}
