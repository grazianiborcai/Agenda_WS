package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

final class VisiCrecardMergePhone extends ActionVisitorTemplateMergeV2<CrecardInfo, PhoneInfo> {
	
	public VisiCrecardMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSearch.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return PhoneCopier.copyFromCrecard(recordInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> recordInfos, List<PhoneInfo> selectedInfos) {	
		return CrecardMerger.mergeWithPhone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
