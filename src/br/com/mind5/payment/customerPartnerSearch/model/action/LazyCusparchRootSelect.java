package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelect;

public final class LazyCusparchRootSelect extends ActionLazyTemplate<CusparchInfo, CusparchInfo> {
	
	public LazyCusparchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusparchInfo> translateRecordInfosHook(List<CusparchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusparchInfo> getInstanceOfActionHook(DeciTreeOption<CusparchInfo> option) {
		return new RootCusparchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusparchInfo> translateResultHook(DeciResult<CusparchInfo> result) {
		return result;
	}
}
