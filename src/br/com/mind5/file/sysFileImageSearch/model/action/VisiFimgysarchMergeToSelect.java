package br.com.mind5.file.sysFileImageSearch.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysarchMergeToSelect extends ActionVisitorTemplateMerge<FimgysarchInfo, FimgysarchInfo> {
	
	public VisiFimgysarchMergeToSelect(DeciTreeOption<FimgysarchInfo> option) {
		super(option, FimgysarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgysarchInfo>> getActionClassHook() {
		return StdFimgysarchDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgysarchInfo> toActionClassHook(List<FimgysarchInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgysarchInfo> mergeHook(List<FimgysarchInfo> baseInfos, List<FimgysarchInfo> selectedInfos) {	
		return FimgysarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
