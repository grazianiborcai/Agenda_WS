package br.com.mind5.payment.countryPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparMerger;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.decisionTree.RootCounparchSelect;

final class VisiCounparMergeCounparch extends ActionVisitorTemplateMergeV1<CounparInfo, CounparchInfo> {
	
	public VisiCounparMergeCounparch(Connection conn, String schemaName) {
		super(conn, schemaName, CounparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparchInfo>> getTreeClassHook() {
		return RootCounparchSelect.class;
	}
	
	
	
	@Override protected List<CounparInfo> mergeHook(List<CounparInfo> baseInfos, List<CounparchInfo> selectedInfos) {
		return CounparMerger.mergeWithCounparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
