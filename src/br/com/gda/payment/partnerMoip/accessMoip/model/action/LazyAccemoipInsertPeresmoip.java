package br.com.gda.payment.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;

public final class LazyAccemoipInsertPeresmoip extends ActionLazyTemplate<AccemoipInfo, AccemoipInfo> {
	
	public LazyAccemoipInsertPeresmoip(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AccemoipInfo> translateRecordInfosHook(List<AccemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AccemoipInfo> getInstanceOfActionHook(DeciTreeOption<AccemoipInfo> option) {
		return new StdAccemoipInsertPeresmoip(option);
	}
	
	
	
	@Override protected DeciResult<AccemoipInfo> translateResultHook(DeciResult<AccemoipInfo> result) {
		return result;
	}
}
