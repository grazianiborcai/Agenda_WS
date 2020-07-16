package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.decisionTree.RootMatypeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapMergeMatype extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatypeInfo> {
	
	public VisiMatsnapMergeMatype(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatypeInfo>> getTreeClassHook() {
		return RootMatypeSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MatypeInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
