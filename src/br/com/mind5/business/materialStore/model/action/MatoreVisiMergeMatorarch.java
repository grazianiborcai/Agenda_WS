package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.decisionTree.RootMatorarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreVisiMergeMatorarch extends ActionVisitorTemplateMerge<MatoreInfo, MatorarchInfo> {
	
	public MatoreVisiMergeMatorarch(DeciTreeOption<MatoreInfo> option) {
		super(option, MatorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatorarchInfo>> getTreeClassHook() {
		return RootMatorarchSelect.class;
	}
	
	
	
	@Override protected List<MatorarchInfo> toActionClassHook(List<MatoreInfo> baseInfos) {
		return MatorarchInfo.copyFrom(baseInfos);	
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<MatorarchInfo> selectedInfos) {	
		return MatoreMerger.mergeWithMatorarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
