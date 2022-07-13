package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiMergeToSelect extends ActionVisitorTemplateMerge<FimgysInfo, FimgysInfo> {
	
	public FimgysVisiMergeToSelect(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimgysInfo>> getVisitorClassHook() {
		return FimgysVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toActionClassHook(List<FimgysInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgysInfo> mergeHook(List<FimgysInfo> baseInfos, List<FimgysInfo> selectedInfos) {	
		return FimgysMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
