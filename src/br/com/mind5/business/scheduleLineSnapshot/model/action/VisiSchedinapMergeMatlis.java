package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisCopier;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.MatlisRootSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeMatlis extends ActionVisitorTemplateMerge<SchedinapInfo, MatlisInfo> {
	
	public VisiSchedinapMergeMatlis(DeciTreeOption<SchedinapInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return MatlisRootSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<SchedinapInfo> baseInfos) {
		return MatlisCopier.copyFromSchedinap(baseInfos);	
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
