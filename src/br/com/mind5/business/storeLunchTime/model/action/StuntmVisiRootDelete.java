package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiRootDelete extends ActionVisitorTemplateAction<StuntmInfo, StuntmInfo> {

	public StuntmVisiRootDelete(DeciTreeOption<StuntmInfo> option) {
		super(option, StuntmInfo.class, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmInfo>> getTreeClassHook() {
		return StuntmRootDelete.class;
	}
	
	
	
	@Override protected List<StuntmInfo> toBaseClassHook(List<StuntmInfo> baseInfos, List<StuntmInfo> results) {
		return results;
	}
}
