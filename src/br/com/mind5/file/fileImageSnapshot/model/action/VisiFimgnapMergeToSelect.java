package br.com.mind5.file.fileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgnapMergeToSelect extends ActionVisitorTemplateMerge<FimgnapInfo, FimgnapInfo> {
	
	public VisiFimgnapMergeToSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option, FimgnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgnapInfo>> getActionClassHook() {
		return StdFimgnapDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgnapInfo> toActionClassHook(List<FimgnapInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgnapInfo> mergeHook(List<FimgnapInfo> baseInfos, List<FimgnapInfo> selectedInfos) {	
		return FimgnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
