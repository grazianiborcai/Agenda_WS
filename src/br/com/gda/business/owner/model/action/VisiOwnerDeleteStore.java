package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreDeleteStore;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteStore extends ActionVisitorTemplateAction<OwnerInfo, OwntoreInfo> {
	public VisiOwnerDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, OwntoreInfo.class);
	}
	
	
	
	@Override protected List<OwntoreInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<OwntoreInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.owntores);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<OwntoreInfo> getActionHook(DeciTreeOption<OwntoreInfo> option) {
		return new RootOwntoreDeleteStore(option).toAction();
	}
}
