package br.com.mind5.file.sysFileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysapVisiMergeToSelect extends ActionVisitorTemplateMerge<FimgysapInfo, FimgysapInfo> {
	
	public FimgysapVisiMergeToSelect(DeciTreeOption<FimgysapInfo> option) {
		super(option, FimgysapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimgysapInfo>> getVisitorClassHook() {
		return FimgysapVisiDaoSelect.class;
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
