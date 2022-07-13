package br.com.mind5.file.fileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgnapVisiMergeToSelect extends ActionVisitorTemplateMerge<FimgnapInfo, FimgnapInfo> {
	
	public FimgnapVisiMergeToSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option, FimgnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimgnapInfo>> getVisitorClassHook() {
		return FimgnapVisiDaoSelect.class;
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
