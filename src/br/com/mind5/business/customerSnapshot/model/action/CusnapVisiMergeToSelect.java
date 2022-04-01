package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusnapVisiMergeToSelect extends ActionVisitorTemplateMerge<CusnapInfo, CusnapInfo> {
	
	public CusnapVisiMergeToSelect(DeciTreeOption<CusnapInfo> option) {
		super(option, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CusnapInfo>> getVisitorClassHook() {
		return CusnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CusnapInfo> mergeHook(List<CusnapInfo> baseInfos, List<CusnapInfo> selectedInfos) {	
		return CusnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
