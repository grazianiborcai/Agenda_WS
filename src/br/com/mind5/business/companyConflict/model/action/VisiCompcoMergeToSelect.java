package br.com.mind5.business.companyConflict.model.action;

import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.info.CompcoMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompcoMergeToSelect extends ActionVisitorTemplateMerge<CompcoInfo, CompcoInfo> {
	
	public VisiCompcoMergeToSelect(DeciTreeOption<CompcoInfo> option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CompcoInfo>> getActionClassHook() {
		return StdCompcoDaoSelect.class;
	}
	
	
	
	@Override protected List<CompcoInfo> mergeHook(List<CompcoInfo> baseInfos, List<CompcoInfo> selectedInfos) {	
		return CompcoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
