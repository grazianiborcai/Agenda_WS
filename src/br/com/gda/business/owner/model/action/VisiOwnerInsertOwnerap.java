package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.model.decisionTree.RootOwnerapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
