package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatlisMergeToSelect extends ActionVisitorTemplateMerge<MatlisInfo, MatlisInfo> {
	
	public VisiMatlisMergeToSelect(DeciTreeOption<MatlisInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatlisInfo>> getActionClassHook() {
		return StdMatlisDaoSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		return MatlisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
