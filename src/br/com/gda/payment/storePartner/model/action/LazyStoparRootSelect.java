package br.com.gda.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decsionTree.RootStoparSelect;

public final class LazyStoparRootSelect extends ActionLazyTemplate<StoparInfo, StoparInfo> {
	
	public LazyStoparRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparInfo> translateRecordInfosHook(List<StoparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoparInfo> getInstanceOfActionHook(DeciTreeOption<StoparInfo> option) {
		return new RootStoparSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoparInfo> translateResultHook(DeciResult<StoparInfo> result) {
		return result;
	}
}
