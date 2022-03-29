package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.OwnelisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnelisVisiRootSelect extends ActionVisitorTemplateAction<OwnelisInfo, OwnelisInfo> {

	public OwnelisVisiRootSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option, OwnelisInfo.class, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return OwnelisRootSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> toBaseClassHook(List<OwnelisInfo> baseInfos, List<OwnelisInfo> results) {
		return results;
	}
}
