package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreMergeStolis extends ActionVisitorTemplateMerge<MatoreInfo, StolisInfo> {
	
	public VisiMatoreMergeStolis(DeciTreeOption<MatoreInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<MatoreInfo> baseInfos) {
		return StolisInfo.copyFrom(baseInfos);	
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return MatoreMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
