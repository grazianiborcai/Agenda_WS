package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulelMergeMatlis extends ActionVisitorTemplateMerge<EmulelInfo, MatlisInfo> {
	
	public VisiEmulelMergeMatlis(DeciTreeOption<EmulelInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<EmulelInfo> mergeHook(List<EmulelInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return EmulelMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
