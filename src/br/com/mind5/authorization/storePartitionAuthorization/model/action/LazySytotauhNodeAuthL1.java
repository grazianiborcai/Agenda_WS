package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.NodeSytotauhAuthL1;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySytotauhNodeAuthL1 extends ActionLazyTemplateV2<SytotauhInfo, SytotauhInfo> {
	
	public LazySytotauhNodeAuthL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SytotauhInfo> translateRecordInfosHook(List<SytotauhInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SytotauhInfo> getInstanceOfActionHook(DeciTreeOption<SytotauhInfo> option) {
		return new NodeSytotauhAuthL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SytotauhInfo> translateResultHook(DeciResult<SytotauhInfo> result) {
		return result;
	}
}
