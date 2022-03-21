package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiMergeToUpdate extends ActionVisitorTemplateMerge<CusInfo, CusInfo> {
	
	public CusVisiMergeToUpdate(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CusInfo>> getVisitorClassHook() {
		return CusVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
