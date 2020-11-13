package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipMerger;

final class VisiPeresmoipMergeToSelect extends ActionVisitorTemplateMerge<PeresmoipInfo, PeresmoipInfo> {
	
	public VisiPeresmoipMergeToSelect(DeciTreeOption<PeresmoipInfo> option) {
		super(option, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PeresmoipInfo>> getActionClassHook() {
		return StdPeresmoipDaoSelect.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> mergeHook(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> selectedInfos) {	
		return PeresmoipMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
