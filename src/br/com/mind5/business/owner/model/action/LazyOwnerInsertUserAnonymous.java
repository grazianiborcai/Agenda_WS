package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnerInsertUserAnonymous extends ActionLazyTemplateV2<OwnerInfo, OwnerInfo> {
	
	public LazyOwnerInsertUserAnonymous(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerInfo> translateRecordInfosHook(List<OwnerInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OwnerInfo> getInstanceOfActionHook(DeciTreeOption<OwnerInfo> option) {
		return new StdOwnerInsertUserAnonymous(option);
	}
	
	
	
	@Override protected DeciResult<OwnerInfo> translateResultHook(DeciResult<OwnerInfo> result) {
		return result;
	}
}
