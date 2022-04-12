package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.SotarchRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SotarchVisiRootSelectUser extends ActionVisitorTemplateAction<SotarchInfo, SotarchInfo> {

	public SotarchVisiRootSelectUser(DeciTreeOption<SotarchInfo> option) {
		super(option, SotarchInfo.class, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return SotarchRootSelectUser.class;
	}
	
	
	
	@Override protected List<SotarchInfo> toBaseClassHook(List<SotarchInfo> baseInfos, List<SotarchInfo> results) {
		return results;
	}
}
