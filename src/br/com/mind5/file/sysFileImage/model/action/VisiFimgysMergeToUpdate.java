package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysMergeToUpdate extends ActionVisitorTemplateMerge<FimgysInfo, FimgysInfo> {
	
	public VisiFimgysMergeToUpdate(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgysInfo>> getActionClassHook() {
		return StdFimgysDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toActionClassHook(List<FimgysInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgysInfo> mergeHook(List<FimgysInfo> baseInfos, List<FimgysInfo> selectedInfos) {	
		return FimgysMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
