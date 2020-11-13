package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapCopier;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeMatsnap extends ActionVisitorTemplateMerge<SchedinapInfo, MatsnapInfo> {
	
	public VisiSchedinapMergeMatsnap(DeciTreeOption<SchedinapInfo> option) {
		super(option, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<SchedinapInfo> baseInfos) {
		return MatsnapCopier.copyFromSchedinap(baseInfos);	
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithMatsnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
