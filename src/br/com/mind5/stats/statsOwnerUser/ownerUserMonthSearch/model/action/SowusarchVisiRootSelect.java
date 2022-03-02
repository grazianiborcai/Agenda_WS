package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.decisionTree.SowusarchRootSelect;

public final class SowusarchVisiRootSelect extends ActionVisitorTemplateAction<SowusarchInfo, SowusarchInfo> {

	public SowusarchVisiRootSelect(DeciTreeOption<SowusarchInfo> option) {
		super(option, SowusarchInfo.class, SowusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusarchInfo>> getTreeClassHook() {
		return SowusarchRootSelect.class;
	}
	
	
	
	@Override protected List<SowusarchInfo> toBaseClassHook(List<SowusarchInfo> baseInfos, List<SowusarchInfo> results) {
		return results;
	}
}
