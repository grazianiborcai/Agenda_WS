package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipMerger;

final class VisiCusmoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<CusmoipInfo, SysEnvironInfo> {
	
	public VisiCusmoipMergeSysEnviron(DeciTreeOption<CusmoipInfo> option) {
		super(option, SysEnvironInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithSysEnviron(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
