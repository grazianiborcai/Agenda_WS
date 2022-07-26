package br.com.mind5.config.sysStoreBusinessContent.model.action;

import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.decisionTree.SytorbcRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytorbcVisiRootSelect extends ActionVisitorTemplateAction<SytorbcInfo, SytorbcInfo> {

	public SytorbcVisiRootSelect(DeciTreeOption<SytorbcInfo> option) {
		super(option, SytorbcInfo.class, SytorbcInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytorbcInfo>> getTreeClassHook() {
		return SytorbcRootSelect.class;
	}
	
	
	
	@Override protected List<SytorbcInfo> toBaseClassHook(List<SytorbcInfo> baseInfos, List<SytorbcInfo> results) {
		return results;
	}
}
