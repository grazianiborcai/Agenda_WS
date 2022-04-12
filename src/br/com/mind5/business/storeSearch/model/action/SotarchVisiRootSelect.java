package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.SotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SotarchVisiRootSelect extends ActionVisitorTemplateAction<SotarchInfo, SotarchInfo> {

	public SotarchVisiRootSelect(DeciTreeOption<SotarchInfo> option) {
		super(option, SotarchInfo.class, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return SotarchRootSelect.class;
	}
	
	
	
	@Override protected List<SotarchInfo> toBaseClassHook(List<SotarchInfo> baseInfos, List<SotarchInfo> results) {
		return results;
	}
}
