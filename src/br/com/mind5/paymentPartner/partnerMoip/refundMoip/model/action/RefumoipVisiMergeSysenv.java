package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.SysenvRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipMerger;

public final class RefumoipVisiMergeSysenv extends ActionVisitorTemplateMerge<RefumoipInfo, SysenvInfo> {
	
	public RefumoipVisiMergeSysenv(DeciTreeOption<RefumoipInfo> option) {
		super(option, SysenvInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return SysenvRootSelect.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
