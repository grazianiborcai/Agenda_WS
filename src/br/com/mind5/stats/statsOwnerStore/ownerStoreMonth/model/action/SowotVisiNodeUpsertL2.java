package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree.SowotNodeUpsertL2;

public final class SowotVisiNodeUpsertL2 extends ActionVisitorTemplateAction<SowotInfo, SowotInfo> {

	public SowotVisiNodeUpsertL2(DeciTreeOption<SowotInfo> option) {
		super(option, SowotInfo.class, SowotInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotInfo>> getTreeClassHook() {
		return SowotNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<SowotInfo> toBaseClassHook(List<SowotInfo> baseInfos, List<SowotInfo> results) {
		return results;
	}
}
