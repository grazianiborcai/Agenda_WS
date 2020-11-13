package br.com.mind5.business.storeText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.NodeStorextDefaultL1;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorextNodeDefaultL1 extends ActionLazyTemplate<StorextInfo, StorextInfo> {

	public LazyStorextNodeDefaultL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorextInfo> translateRecordInfosHook(List<StorextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorextInfo> getInstanceOfActionHook(DeciTreeOption<StorextInfo> option) {
		return new NodeStorextDefaultL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorextInfo> translateResultHook(DeciResult<StorextInfo> result) {
		return result;
	}
}
