package br.com.mind5.business.storeTime_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.business.storeTime_.model.decisionTree.NodeStorimeSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorimeNodeSelect extends ActionLazyTemplate<StorimeInfo, StorimeInfo> {

	public LazyStorimeNodeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorimeInfo> translateRecordInfosHook(List<StorimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<StorimeInfo> getInstanceOfActionHook(DeciTreeOption<StorimeInfo> option) {
		return new NodeStorimeSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorimeInfo> translateResultHook(DeciResult<StorimeInfo> result) {
		return result;
	}
}
