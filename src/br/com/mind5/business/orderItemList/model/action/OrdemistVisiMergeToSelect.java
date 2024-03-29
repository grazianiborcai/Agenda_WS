package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.info.OrdemistMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemistVisiMergeToSelect extends ActionVisitorTemplateMerge<OrdemistInfo, OrdemistInfo> {
	
	public OrdemistVisiMergeToSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option, OrdemistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrdemistInfo>> getVisitorClassHook() {
		return OrdemistVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemistInfo> mergeHook(List<OrdemistInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return OrdemistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
