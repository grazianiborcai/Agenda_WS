package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeEmplis extends ActionVisitorTemplateMerge<SchedinapInfo, EmplisInfo> {
	
	public VisiSchedinapMergeEmplis(DeciTreeOption<SchedinapInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
