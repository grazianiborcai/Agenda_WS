package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmMerger;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.model.decisionTree.StuntmapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiStuntmapInsert extends ActionVisitorTemplateAction<StuntmInfo, StuntmapInfo> {

	public StuntmVisiStuntmapInsert(DeciTreeOption<StuntmInfo> option) {
		super(option, StuntmInfo.class, StuntmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmapInfo>> getTreeClassHook() {
		return StuntmapRootInsert.class;
	}
	
	
	
	protected List<StuntmInfo> toBaseClassHook(List<StuntmInfo> baseInfos, List<StuntmapInfo> selectedInfos) {
		return StuntmMerger.mergeWithStuntmap(baseInfos, selectedInfos);
	}
}
