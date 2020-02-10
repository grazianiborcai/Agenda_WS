package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipMerger;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.RootUselisSelect;

final class VisiCusmoipMergeUselis extends ActionVisitorTemplateMergeV2<CusmoipInfo, UselisInfo> {
	
	public VisiCusmoipMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> toActionClassHook(List<CusmoipInfo> baseInfos) {
		return UselisCopier.copyFromCusmoip(baseInfos);	
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
