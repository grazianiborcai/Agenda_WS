package br.com.gda.payment.partnerMoip.creditCardMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class LazyCremoipEnforceDocument extends ActionLazyTemplate<CremoipInfo, CremoipInfo> {

	public LazyCremoipEnforceDocument(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CremoipInfo> translateRecordInfosHook(List<CremoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CremoipInfo> getInstanceOfActionHook(DeciTreeOption<CremoipInfo> option) {
		return new StdCremoipEnforceDocument(option);
	}
	
	
	
	@Override protected DeciResult<CremoipInfo> translateResultHook(DeciResult<CremoipInfo> result) {
		return result;
	}
}
