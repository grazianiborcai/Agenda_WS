package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.business.phoneSnapshotSearch.model.decisionTree.RootPhonaparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapVisiMergePhonaparch extends ActionVisitorTemplateMerge<PhonapInfo, PhonaparchInfo> {
	
	public PhonapVisiMergePhonaparch(DeciTreeOption<PhonapInfo> option) {
		super(option, PhonaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonaparchInfo>> getTreeClassHook() {
		return RootPhonaparchSelect.class;
	}
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<PhonaparchInfo> selectedInfos) {	
		return PhonapMerger.mergeWithPhonaparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
