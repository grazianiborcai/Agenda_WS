package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateDeleteByStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteStolate extends ActionVisitorTemplateAction<StoreInfo, StolateInfo> {
	public VisiStoreDeleteStolate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StolateInfo> getActionHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateDeleteByStore(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StolateInfo> results) {
		return baseInfos;
	}
}
