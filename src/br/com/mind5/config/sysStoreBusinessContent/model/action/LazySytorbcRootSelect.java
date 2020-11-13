package br.com.mind5.config.sysStoreBusinessContent.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.decisionTree.RootSytorbcSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySytorbcRootSelect extends ActionLazyTemplate<SytorbcInfo, SytorbcInfo> {

	public LazySytorbcRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SytorbcInfo> translateRecordInfosHook(List<SytorbcInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SytorbcInfo> getInstanceOfActionHook(DeciTreeOption<SytorbcInfo> option) {
		return new RootSytorbcSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SytorbcInfo> translateResultHook(DeciResult<SytorbcInfo> result) {
		return result;
	}
}
