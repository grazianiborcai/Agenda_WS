package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;

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
