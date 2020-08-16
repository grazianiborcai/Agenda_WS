package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorapMergeToSelect extends ActionVisitorTemplateMergeV2<MatorapInfo, MatorapInfo> {
	
	public VisiMatorapMergeToSelect(DeciTreeOption<MatorapInfo> option) {
		super(option, MatorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatorapInfo>> getActionClassHook() {
		return StdMatorapDaoSelect.class;
	}
	
	
	
	@Override protected List<MatorapInfo> mergeHook(List<MatorapInfo> baseInfos, List<MatorapInfo> selectedInfos) {	
		return MatorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
