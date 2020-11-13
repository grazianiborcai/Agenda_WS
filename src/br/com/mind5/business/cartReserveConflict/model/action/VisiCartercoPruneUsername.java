package br.com.mind5.business.cartReserveConflict.model.action;

import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCartercoPruneUsername extends ActionVisitorTemplatePrune<CartercoInfo, UsernameInfo> {
	
	public VisiCartercoPruneUsername(DeciTreeOption<CartercoInfo> option) {
		super(option, UsernameInfo.class);
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
