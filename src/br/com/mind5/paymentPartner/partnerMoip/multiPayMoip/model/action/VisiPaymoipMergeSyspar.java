package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.decisionTree.RootSysparSelect;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipMerger;

final class VisiPaymoipMergeSyspar extends ActionVisitorTemplateMerge<PaymoipInfo, SysparInfo> {
	
	public VisiPaymoipMergeSyspar(DeciTreeOption<PaymoipInfo> option) {
		super(option, SysparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysparInfo>> getTreeClassHook() {
		return RootSysparSelect.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> baseInfos, List<SysparInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSyspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
