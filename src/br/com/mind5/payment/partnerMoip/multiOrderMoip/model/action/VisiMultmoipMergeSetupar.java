package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipMerger;
import br.com.mind5.payment.setupPartner.info.SetuparCopier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiMultmoipMergeSetupar extends ActionVisitorTemplateMergeV2<MultmoipInfo, SetuparInfo> {
	
	public VisiMultmoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<MultmoipInfo> recordInfos) {
		return SetuparCopier.copyFromMultmoip(recordInfos);	
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
