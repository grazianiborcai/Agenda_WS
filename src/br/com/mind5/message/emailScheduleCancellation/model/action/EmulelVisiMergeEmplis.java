package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.EmplisRootSelect;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmulelVisiMergeEmplis extends ActionVisitorTemplateMerge<EmulelInfo, EmplisInfo> {
	
	public EmulelVisiMergeEmplis(DeciTreeOption<EmulelInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return EmplisRootSelect.class;
	}
	
	
	
	@Override protected List<EmulelInfo> mergeHook(List<EmulelInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return EmulelMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
