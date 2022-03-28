package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.info.ComplisMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComplisVisiMergeToSelect extends ActionVisitorTemplateMerge<ComplisInfo, ComplisInfo> {
	
	public ComplisVisiMergeToSelect(DeciTreeOption<ComplisInfo> option) {
		super(option, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<ComplisInfo>> getVisitorClassHook() {
		return ComplisVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<ComplisInfo> mergeHook(List<ComplisInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return ComplisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
