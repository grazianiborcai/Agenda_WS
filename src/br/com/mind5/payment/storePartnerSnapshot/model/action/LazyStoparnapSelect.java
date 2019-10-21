package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class LazyStoparnapSelect extends ActionLazyTemplate<StoparnapInfo, StoparnapInfo> {
	
	public LazyStoparnapSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparnapInfo> translateRecordInfosHook(List<StoparnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoparnapInfo> getInstanceOfActionHook(DeciTreeOption<StoparnapInfo> option) {
		return new StdStoparnapSelect(option);
	}
	
	
	
	@Override protected DeciResult<StoparnapInfo> translateResultHook(DeciResult<StoparnapInfo> result) {
		return result;
	}
}
