package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.decisionTree.StusorygeRootUpsert;

public final class StusorygeVisiRootUpsert extends ActionVisitorTemplateAction<StusorygeInfo, StusorygeInfo> {

	public StusorygeVisiRootUpsert(DeciTreeOption<StusorygeInfo> option) {
		super(option, StusorygeInfo.class, StusorygeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygeInfo>> getTreeClassHook() {
		return StusorygeRootUpsert.class;
	}
	
	
	
	@Override protected List<StusorygeInfo> toBaseClassHook(List<StusorygeInfo> baseInfos, List<StusorygeInfo> results) {
		return results;
	}
}
