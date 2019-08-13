package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.model.decisionTree.RootStorapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreInsertStorap extends ActionVisitorTemplateAction<StoreInfo, StorapInfo> {

	public VisiStoreInsertStorap(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StorapInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorapInfo> getActionHook(DeciTreeOption<StorapInfo> option) {
		return new RootStorapInsert(option).toAction();
	}
	
	
	
	protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StorapInfo> results) {
		return StoreMerger.mergeWithStorap(results, baseInfos);
	}
}
