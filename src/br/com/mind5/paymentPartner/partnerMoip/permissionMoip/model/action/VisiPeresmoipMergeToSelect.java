package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipMerger;

final class VisiPeresmoipMergeToSelect extends ActionVisitorTemplateMergeV2<PeresmoipInfo, PeresmoipInfo> {
	
	public VisiPeresmoipMergeToSelect(DeciTreeOption<PeresmoipInfo> option) {
		super(option, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PeresmoipInfo>> getActionClassHook() {
		return StdPeresmoipDaoSelect.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> mergeHook(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> selectedInfos) {	
		return PeresmoipMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
