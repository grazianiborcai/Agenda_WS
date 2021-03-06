package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorapMergeToSelect extends ActionVisitorTemplateMerge<MatorapInfo, MatorapInfo> {
	
	public VisiMatorapMergeToSelect(DeciTreeOption<MatorapInfo> option) {
		super(option, MatorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatorapInfo>> getActionClassHook() {
		return StdMatorapDaoSelect.class;
	}
	
	
	
	@Override protected List<MatorapInfo> mergeHook(List<MatorapInfo> baseInfos, List<MatorapInfo> selectedInfos) {	
		return MatorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
