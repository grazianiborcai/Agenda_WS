package br.com.mind5.payment.ownerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class LazyOwnparMergeOwner extends ActionLazyTemplateV2<OwnparInfo, OwnparInfo> {
	
	public LazyOwnparMergeOwner(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnparInfo> translateRecordInfosHook(List<OwnparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OwnparInfo> getInstanceOfActionHook(DeciTreeOption<OwnparInfo> option) {
		return new StdOwnparMergeOwner(option);
	}
	
	
	
	@Override protected DeciResult<OwnparInfo> translateResultHook(DeciResult<OwnparInfo> result) {
		return result;
	}
}
