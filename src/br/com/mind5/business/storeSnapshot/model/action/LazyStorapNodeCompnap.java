package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.decisionTree.NodeStorapCompnap;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorapNodeCompnap extends ActionLazyTemplateV2<StorapInfo, StorapInfo> {
	
	public LazyStorapNodeCompnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorapInfo> translateRecordInfosHook(List<StorapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorapInfo> getInstanceOfActionHook(DeciTreeOption<StorapInfo> option) {
		return new NodeStorapCompnap(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorapInfo> translateResultHook(DeciResult<StorapInfo> result) {
		return result;
	}
}
