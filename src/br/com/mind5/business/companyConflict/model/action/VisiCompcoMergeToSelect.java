package br.com.mind5.business.companyConflict.model.action;

import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.info.CompcoMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompcoMergeToSelect extends ActionVisitorTemplateMergeV2<CompcoInfo, CompcoInfo> {
	
	public VisiCompcoMergeToSelect(DeciTreeOption<CompcoInfo> option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CompcoInfo>> getActionClassHook() {
		return StdCompcoDaoSelect.class;
	}
	
	
	
	@Override protected List<CompcoInfo> mergeHook(List<CompcoInfo> baseInfos, List<CompcoInfo> selectedInfos) {	
		return CompcoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
