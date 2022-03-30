package br.com.mind5.business.feeOwner.model.action;

import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.decisionTree.FeewnerRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeewnerVisiRootSelect extends ActionVisitorTemplateAction<FeewnerInfo, FeewnerInfo> {

	public FeewnerVisiRootSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option, FeewnerInfo.class, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeewnerInfo>> getTreeClassHook() {
		return FeewnerRootSelect.class;
	}
	
	
	
	@Override protected List<FeewnerInfo> toBaseClassHook(List<FeewnerInfo> baseInfos, List<FeewnerInfo> results) {
		return results;
	}
}
