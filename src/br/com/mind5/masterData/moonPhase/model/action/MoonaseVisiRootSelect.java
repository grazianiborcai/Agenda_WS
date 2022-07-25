package br.com.mind5.masterData.moonPhase.model.action;

import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.MoonaseRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseVisiRootSelect extends ActionVisitorTemplateAction<MoonaseInfo, MoonaseInfo> {

	public MoonaseVisiRootSelect(DeciTreeOption<MoonaseInfo> option) {
		super(option, MoonaseInfo.class, MoonaseInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonaseInfo>> getTreeClassHook() {
		return MoonaseRootSelect.class;
	}
	
	
	
	@Override protected List<MoonaseInfo> toBaseClassHook(List<MoonaseInfo> baseInfos, List<MoonaseInfo> results) {
		return results;
	}
}
