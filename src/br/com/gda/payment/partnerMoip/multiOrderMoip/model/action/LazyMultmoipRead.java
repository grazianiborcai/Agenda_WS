package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class LazyMultmoipRead extends ActionLazyTemplate<MultmoipInfo, MultmoipInfo> {

	public LazyMultmoipRead(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MultmoipInfo> translateRecordInfosHook(List<MultmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MultmoipInfo> getInstanceOfActionHook(DeciTreeOption<MultmoipInfo> option) {
		return new StdMultmoipRead(option);
	}
	
	
	
	@Override protected DeciResult<MultmoipInfo> translateResultHook(DeciResult<MultmoipInfo> result) {
		return result;
	}
}
