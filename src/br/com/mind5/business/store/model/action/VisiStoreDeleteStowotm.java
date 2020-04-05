package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmDeleteByStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStowotm extends ActionVisitorTemplateActionV1<StoreInfo, StowotmInfo> {
	public VisiStoreDeleteStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StowotmInfo> getActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmDeleteByStore(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StowotmInfo> results) {
		return baseInfos;
	}
}
