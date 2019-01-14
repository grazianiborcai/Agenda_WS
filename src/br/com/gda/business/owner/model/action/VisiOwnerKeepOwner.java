package br.com.gda.business.owner.model.action;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerKeeper;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateKeep;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerKeepOwner extends ActionVisitorTemplateKeep<OwnerInfo, OwnerInfo> {

	public VisiOwnerKeepOwner(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class);
	}
	
	
	
	@Override protected ActionStd<OwnerInfo> getActionHook(DeciTreeOption<OwnerInfo> option) {
		ActionStd<OwnerInfo> actionSelect = new StdOwnerEnforceKey(option);
		actionSelect.addPostAction(new LazyOwnerRootSelect(option.conn, option.schemaName));
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OwnerInfo>> getKeeperClassHook() {
		return OwnerKeeper.class;
	}
}
