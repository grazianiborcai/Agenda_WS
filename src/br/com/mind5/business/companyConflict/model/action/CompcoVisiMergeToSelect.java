package br.com.mind5.business.companyConflict.model.action;

import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.business.companyConflict.info.CompcoMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompcoVisiMergeToSelect extends ActionVisitorTemplateMerge<CompcoInfo, CompcoInfo> {
	
	public CompcoVisiMergeToSelect(DeciTreeOption<CompcoInfo> option) {
		super(option, CompcoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CompcoInfo>> getVisitorClassHook() {
		return CompcoVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CompcoInfo> mergeHook(List<CompcoInfo> baseInfos, List<CompcoInfo> selectedInfos) {	
		return CompcoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
