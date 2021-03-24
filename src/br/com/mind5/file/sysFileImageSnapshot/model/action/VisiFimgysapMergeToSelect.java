package br.com.mind5.file.sysFileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysapMergeToSelect extends ActionVisitorTemplateMerge<FimgysapInfo, FimgysapInfo> {
	
	public VisiFimgysapMergeToSelect(DeciTreeOption<FimgysapInfo> option) {
		super(option, FimgysapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgysapInfo>> getActionClassHook() {
		return StdFimgysapDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgysapInfo> toActionClassHook(List<FimgysapInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgysapInfo> mergeHook(List<FimgysapInfo> baseInfos, List<FimgysapInfo> selectedInfos) {	
		return FimgysapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
