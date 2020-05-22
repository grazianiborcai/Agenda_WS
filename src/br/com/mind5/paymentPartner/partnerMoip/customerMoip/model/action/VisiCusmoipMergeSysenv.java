package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.RootSysenvSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipMerger;

final class VisiCusmoipMergeSysenv extends ActionVisitorTemplateMergeV2<CusmoipInfo, SysenvInfo> {
	
	public VisiCusmoipMergeSysenv(DeciTreeOption<CusmoipInfo> option) {
		super(option, SysenvInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return RootSysenvSelect.class;
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
