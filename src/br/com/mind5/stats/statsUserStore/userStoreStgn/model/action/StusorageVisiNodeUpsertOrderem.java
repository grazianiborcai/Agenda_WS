package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree.StusorageNodeUpsertOrderem;

public final class StusorageVisiNodeUpsertOrderem extends ActionVisitorTemplateAction<StusorageInfo, StusorageInfo> {

	public StusorageVisiNodeUpsertOrderem(DeciTreeOption<StusorageInfo> option) {
		super(option, StusorageInfo.class, StusorageInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorageInfo>> getTreeClassHook() {
		return StusorageNodeUpsertOrderem.class;
	}
	
	
	
	@Override protected List<StusorageInfo> toBaseClassHook(List<StusorageInfo> baseInfos, List<StusorageInfo> results) {
		return results;
	}
}
