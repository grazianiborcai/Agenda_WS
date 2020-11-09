package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class LazyStoparnapMergePaypar extends ActionLazyTemplateV2<StoparnapInfo, StoparnapInfo> {
	
	public LazyStoparnapMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparnapInfo> translateRecordInfosHook(List<StoparnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoparnapInfo> getInstanceOfActionHook(DeciTreeOption<StoparnapInfo> option) {
		return new StdStoparnapMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<StoparnapInfo> translateResultHook(DeciResult<StoparnapInfo> result) {
		return result;
	}
}
