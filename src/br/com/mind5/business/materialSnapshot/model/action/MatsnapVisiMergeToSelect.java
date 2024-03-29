package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatsnapVisiMergeToSelect extends ActionVisitorTemplateMerge<MatsnapInfo, MatsnapInfo> {
	
	public MatsnapVisiMergeToSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatsnapInfo>> getVisitorClassHook() {
		return MatsnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<MatsnapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {	
		return MatsnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
