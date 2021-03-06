package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.decisionTree.RootFimgysarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysMergeFimgysarch extends ActionVisitorTemplateMerge<FimgysInfo, FimgysarchInfo> {
	
	public VisiFimgysMergeFimgysarch(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysarchInfo>> getTreeClassHook() {
		return RootFimgysarchSelect.class;
	}
	
	
	
	@Override protected List<FimgysInfo> mergeHook(List<FimgysInfo> baseInfos, List<FimgysarchInfo> selectedInfos) {	
		return FimgysMerger.mergeWithFimgysarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
