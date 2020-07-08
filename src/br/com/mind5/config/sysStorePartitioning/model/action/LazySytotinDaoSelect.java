package br.com.mind5.config.sysStorePartitioning.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySytotinDaoSelect extends ActionLazyTemplateV2<SytotinInfo, SytotinInfo> {

	public LazySytotinDaoSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SytotinInfo> translateRecordInfosHook(List<SytotinInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SytotinInfo> getInstanceOfActionHook(DeciTreeOption<SytotinInfo> option) {
		return new StdSytotinDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<SytotinInfo> translateResultHook(DeciResult<SytotinInfo> result) {
		return result;
	}
}
