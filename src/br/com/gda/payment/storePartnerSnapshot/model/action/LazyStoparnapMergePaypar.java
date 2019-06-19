package br.com.gda.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class LazyStoparnapMergePaypar extends ActionLazyTemplate<StoparnapInfo, StoparnapInfo> {
	
	public LazyStoparnapMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparnapInfo> translateRecordInfosHook(List<StoparnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoparnapInfo> getInstanceOfActionHook(DeciTreeOption<StoparnapInfo> option) {
		return new StdStoparnapMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<StoparnapInfo> translateResultHook(DeciResult<StoparnapInfo> result) {
		return result;
	}
}
