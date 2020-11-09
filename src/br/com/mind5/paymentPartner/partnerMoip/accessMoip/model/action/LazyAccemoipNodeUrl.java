package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree.NodeAccemoipUrl;

public final class LazyAccemoipNodeUrl extends ActionLazyTemplateV2<AccemoipInfo, AccemoipInfo> {
	
	public LazyAccemoipNodeUrl(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AccemoipInfo> translateRecordInfosHook(List<AccemoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<AccemoipInfo> getInstanceOfActionHook(DeciTreeOption<AccemoipInfo> option) {
		return new NodeAccemoipUrl(option).toAction();
	}
	
	
	
	@Override protected DeciResult<AccemoipInfo> translateResultHook(DeciResult<AccemoipInfo> result) {
		return result;
	}
}
