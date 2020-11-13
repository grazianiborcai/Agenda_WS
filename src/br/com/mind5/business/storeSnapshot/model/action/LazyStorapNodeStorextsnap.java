package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.decisionTree.NodeStorapStorextsnap;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorapNodeStorextsnap extends ActionLazyTemplate<StorapInfo, StorapInfo> {
	
	public LazyStorapNodeStorextsnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorapInfo> translateRecordInfosHook(List<StorapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<StorapInfo> getInstanceOfActionHook(DeciTreeOption<StorapInfo> option) {
		return new NodeStorapStorextsnap(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorapInfo> translateResultHook(DeciResult<StorapInfo> result) {
		return result;
	}
}
