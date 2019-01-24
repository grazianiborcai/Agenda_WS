package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.StdStoreEnforceCnpj;
import br.com.gda.business.store.model.action.LazyStoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCheckExistCnpj_ extends ModelCheckerTemplateAction<StoreInfo> {
	
	public StoreCheckExistCnpj_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> buildActionHook(StoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<StoreInfo> actionSelect = new StdStoreEnforceCnpj(option);
		actionSelect.addPostAction(new LazyStoreSelect(conn, schemaName));
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_CNPJ_ALREADY_EXIST)
			return SystemMessage.STORE_CNPJ_ALREADY_EXIST;
		
		return SystemMessage.STORE_CNPJ_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_CNPJ_ALREADY_EXIST;	
			
		return SystemCode.STORE_CNPJ_NOT_FOUND;
	}
}
