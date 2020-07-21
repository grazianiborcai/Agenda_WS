package br.com.mind5.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOwnerapMergeUselis extends ActionLazyTemplateV2<OwnerapInfo, OwnerapInfo> {
	
	public LazyOwnerapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerapInfo> translateRecordInfosHook(List<OwnerapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OwnerapInfo> getInstanceOfActionHook(DeciTreeOption<OwnerapInfo> option) {
		return new StdOwnerapMergeUselis(option);
	}
	
	
	
	@Override protected DeciResult<OwnerapInfo> translateResultHook(DeciResult<OwnerapInfo> result) {
		return result;
	}
}
