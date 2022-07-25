package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.SysenvRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

public final class OrdmoipVisiMergeSysenv extends ActionVisitorTemplateMerge<OrdmoipInfo, SysenvInfo> {
	
	public OrdmoipVisiMergeSysenv(DeciTreeOption<OrdmoipInfo> option) {
		super(option, SysenvInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return SysenvRootSelect.class;
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithSysEnviron(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
