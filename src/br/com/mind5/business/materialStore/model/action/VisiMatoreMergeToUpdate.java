package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreMergeToUpdate extends ActionVisitorTemplateMergeV2<MatoreInfo, MatoreInfo> {
	
	public VisiMatoreMergeToUpdate(DeciTreeOption<MatoreInfo> option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatoreInfo>> getActionClassHook() {
		return StdMatoreDaoSelect.class;
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return MatoreMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
