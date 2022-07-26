package br.com.mind5.config.sysStorePartitioning.model.action;

import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.decisionTree.SytotinRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotinVisiRootSelect extends ActionVisitorTemplateAction<SytotinInfo, SytotinInfo> {

	public SytotinVisiRootSelect(DeciTreeOption<SytotinInfo> option) {
		super(option, SytotinInfo.class, SytotinInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotinInfo>> getTreeClassHook() {
		return SytotinRootSelect.class;
	}
	
	
	
	@Override protected List<SytotinInfo> toBaseClassHook(List<SytotinInfo> baseInfos, List<SytotinInfo> results) {
		return results;
	}
}
