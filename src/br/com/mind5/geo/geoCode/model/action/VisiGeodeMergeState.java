package br.com.mind5.geo.geoCode.model.action;

import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.info.GeodeMerger;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGeodeMergeState extends ActionVisitorTemplateMergeV2<GeodeInfo, StateInfo> {
	
	public VisiGeodeMergeState(DeciTreeOption<GeodeInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<GeodeInfo> mergeHook(List<GeodeInfo> baseInfos, List<StateInfo> selectedInfos) {
		return GeodeMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
