package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.decisionTree.RootOwnerapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerInsertOwnerap extends ActionVisitorTemplateAction<OwnerInfo, OwnerapInfo> {

	public VisiOwnerInsertOwnerap(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, OwnerapInfo.class);
	}
	
	
	
	@Override protected ActionStd<OwnerapInfo> getActionHook(DeciTreeOption<OwnerapInfo> option) {
		return new RootOwnerapInsert(option).toAction();
	}
	
	
	
	protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<OwnerapInfo> results) {
		return OwnerMerger.mergeWithOwnerap(results, baseInfos);
	}
}
