package br.com.mind5.payment.ownerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.decisionTree.RootCounparSelect;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparMerger;

final class VisiOwnparMergeCounpar extends ActionVisitorTemplateMergeV2<OwnparInfo, CounparInfo> {
	
	public VisiOwnparMergeCounpar(Connection conn, String schemaName) {
		super(conn, schemaName, CounparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparInfo>> getTreeClassHook() {
		return RootCounparSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> mergeHook(List<OwnparInfo> recordInfos, List<CounparInfo> selectedInfos) {	
		return OwnparMerger.mergeWithCounpar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
