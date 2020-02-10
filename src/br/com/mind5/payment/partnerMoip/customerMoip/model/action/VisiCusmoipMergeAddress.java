package br.com.mind5.payment.partnerMoip.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipMerger;

final class VisiCusmoipMergeAddress extends ActionVisitorTemplateMergeV2<CusmoipInfo, AddressInfo> {
	
	public VisiCusmoipMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CusmoipInfo> baseInfos) {
		return AddressCopier.copyFromCusmoip(baseInfos);	
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
