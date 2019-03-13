package br.com.gda.business.storeTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.business.storeTime.model.decisionTree.NodeStorimeSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
