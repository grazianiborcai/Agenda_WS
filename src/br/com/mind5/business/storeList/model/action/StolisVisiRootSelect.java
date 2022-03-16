package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisVisiRootSelect extends ActionVisitorTemplateAction<StolisInfo, StolisInfo> {

	public StolisVisiRootSelect(DeciTreeOption<StolisInfo> option) {
		super(option, StolisInfo.class, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toBaseClassHook(List<StolisInfo> baseInfos, List<StolisInfo> results) {
		return results;
	}
}
