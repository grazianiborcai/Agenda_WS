package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.ActionStoreEnforceCnpj;
import br.com.gda.business.store.model.decisionTree.HandlerStoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCheckExistCnpj extends ModelCheckerTemplateAction<StoreInfo> {
	
	public StoreCheckExistCnpj(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreInfo> buildActionHook(StoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreInfo> actionSelect = new ActionStoreEnforceCnpj(option);
		actionSelect.addPostAction(new HandlerStoreSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreInfo> buildOption(StoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_CNPJ_ALREADY_EXIST)
			return SystemMessage.STORE_CNPJ_ALREADY_EXIST;
		
		return SystemMessage.STORE_CNPJ_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_CNPJ_ALREADY_EXIST;	
			
		return SystemCode.STORE_CNPJ_NOT_FOUND;
	}
}
