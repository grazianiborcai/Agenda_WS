package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree.SowusNodeUpsertL2;

public final class SowusVisiNodeUpsertL2 extends ActionVisitorTemplateAction<SowusInfo, SowusInfo> {

	public SowusVisiNodeUpsertL2(DeciTreeOption<SowusInfo> option) {
		super(option, SowusInfo.class, SowusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusInfo>> getTreeClassHook() {
		return SowusNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<SowusInfo> toBaseClassHook(List<SowusInfo> baseInfos, List<SowusInfo> results) {
		return results;
	}
}
