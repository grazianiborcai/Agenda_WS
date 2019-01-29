package br.com.gda.business.storeEmployee.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.action.StdStoreEmpEnforceDel;
import br.com.gda.business.storeEmployee.model.action.LazyStoreEmpSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreEmpCheckSoftDelete extends ModelCheckerTemplateAction<StoreEmpInfo> {
	
	public StoreEmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoreEmpInfo> buildActionHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreEmpInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StoreEmpInfo> actionSelect = new StdStoreEmpEnforceDel(option);
		actionSelect.addPostAction(new LazyStoreEmpSelect(conn, schemaName));		
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_EMP_FLAGGED_AS_DELETED;	
	}
}
