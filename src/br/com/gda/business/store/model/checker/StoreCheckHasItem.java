package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.StdStoreEnforceOwnerKey;
import br.com.gda.business.store.model.action.LazyStoreSelect_;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreCheckHasItem extends ModelCheckerTemplateAction_<StoreInfo> {
	
	public StoreCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoreInfo> buildActionHook(StoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<StoreInfo> enforceOwnerKey = new StdStoreEnforceOwnerKey(option);
		ActionLazy<StoreInfo> select = new LazyStoreSelect_(conn, schemaName);
		
		enforceOwnerKey.addPostAction(select);
		return enforceOwnerKey;
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
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_HAS_ITEM)
			return SystemMessage.STORE_HAS_ITEM ;
		
		return SystemMessage.STORE_NO_ITEM_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STORE_HAS_ITEM;	
			
		return SystemCode.STORE_NO_ITEM_FOUND;
	}
}
