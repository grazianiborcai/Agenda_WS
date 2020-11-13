package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulelMergeEmplis extends ActionVisitorTemplateMerge<EmulelInfo, EmplisInfo> {
	
	public VisiEmulelMergeEmplis(DeciTreeOption<EmulelInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmulelInfo> mergeHook(List<EmulelInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return EmulelMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
