package br.com.mind5.business.cartReserveConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCartercoPruneUsername extends ActionVisitorTemplatePruneV1<CartercoInfo, UsernameInfo> {
	
	public VisiCartercoPruneUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CartercoInfo> recordInfos) {
		return UsernameCopier.copyFromCarterco(recordInfos);	
	}
	
	
	
	@Override protected List<CartercoInfo> pruneHook(List<CartercoInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return CartercoPruner.pruneWithUsername(recordInfos, selectedInfos);
	}
}
