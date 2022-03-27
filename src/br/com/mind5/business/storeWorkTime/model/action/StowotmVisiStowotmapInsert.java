package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.model.decisionTree.StowotmapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmVisiStowotmapInsert extends ActionVisitorTemplateAction<StowotmInfo, StowotmapInfo> {

	public StowotmVisiStowotmapInsert(DeciTreeOption<StowotmInfo> option) {
		super(option, StowotmInfo.class, StowotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmapInfo>> getTreeClassHook() {
		return StowotmapRootInsert.class;
	}
	
	
	
	protected List<StowotmInfo> toBaseClassHook(List<StowotmInfo> baseInfos, List<StowotmapInfo> selectedInfos) {
		return StowotmMerger.mergeWithStowotmap(baseInfos, selectedInfos);
	}
}
