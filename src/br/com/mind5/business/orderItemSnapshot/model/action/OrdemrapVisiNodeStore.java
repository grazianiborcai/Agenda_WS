package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.decisionTree.OrdemrapNodeStore;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemrapVisiNodeStore extends ActionVisitorTemplateAction<OrdemrapInfo, OrdemrapInfo> {

	public OrdemrapVisiNodeStore(DeciTreeOption<OrdemrapInfo> option) {
		super(option, OrdemrapInfo.class, OrdemrapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemrapInfo>> getTreeClassHook() {
		return OrdemrapNodeStore.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> toBaseClassHook(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> results) {
		return results;
	}
}
