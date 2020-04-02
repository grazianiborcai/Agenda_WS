package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreCopier;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreDeleteByStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteMatore extends ActionVisitorTemplateAction<StoreInfo, MatoreInfo> {
	public VisiStoreDeleteMatore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatoreInfo> getActionHook(DeciTreeOption<MatoreInfo> option) {
		return new RootMatoreDeleteByStore(option).toAction();
	}
	
	
	
	@Override protected List<MatoreInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return MatoreCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<MatoreInfo> results) {
		return baseInfos;
	}
}
