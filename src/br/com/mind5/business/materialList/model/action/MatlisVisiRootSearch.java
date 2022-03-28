package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.MatlisRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiRootSearch extends ActionVisitorTemplateAction<MatlisInfo, MatlisInfo> {

	public MatlisVisiRootSearch(DeciTreeOption<MatlisInfo> option) {
		super(option, MatlisInfo.class, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return MatlisRootSearch.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toBaseClassHook(List<MatlisInfo> baseInfos, List<MatlisInfo> results) {
		return results;
	}
}
