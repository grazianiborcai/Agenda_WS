package br.com.mind5.business.orderSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdnapVisiMergeToSelect extends ActionVisitorTemplateMerge<OrdnapInfo, OrdnapInfo> {
	
	public OrdnapVisiMergeToSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option, OrdnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrdnapInfo>> getVisitorClassHook() {
		return OrdnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {	
		return OrdnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
