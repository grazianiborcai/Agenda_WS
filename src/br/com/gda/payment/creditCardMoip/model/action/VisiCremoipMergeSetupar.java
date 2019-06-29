package br.com.gda.payment.creditCardMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.creditCardMoip.info.CremoipMerger;
import br.com.gda.payment.setupPartner.info.SetuparCopier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiCremoipMergeSetupar extends ActionVisitorTemplateMergeV2<CremoipInfo, SetuparInfo> {
	
	public VisiCremoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<CremoipInfo> recordInfos) {
		return SetuparCopier.copyFromCremoip(recordInfos);	
	}
	
	
	
	@Override protected List<CremoipInfo> mergeHook(List<CremoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return CremoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
