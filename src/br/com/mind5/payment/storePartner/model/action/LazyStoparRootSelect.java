package br.com.mind5.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.RootStoparSelect;

public final class LazyStoparRootSelect extends ActionLazyTemplate<StoparInfo, StoparInfo> {
	
	public LazyStoparRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparInfo> translateRecordInfosHook(List<StoparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<StoparInfo> getInstanceOfActionHook(DeciTreeOption<StoparInfo> option) {
		return new RootStoparSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoparInfo> translateResultHook(DeciResult<StoparInfo> result) {
		return result;
	}
}
