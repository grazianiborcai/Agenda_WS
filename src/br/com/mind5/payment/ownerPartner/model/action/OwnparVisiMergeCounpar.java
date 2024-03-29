package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.decisionTree.CounparRootSelect;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparMerger;

public final class OwnparVisiMergeCounpar extends ActionVisitorTemplateMerge<OwnparInfo, CounparInfo> {
	
	public OwnparVisiMergeCounpar(DeciTreeOption<OwnparInfo> option) {
		super(option, CounparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparInfo>> getTreeClassHook() {
		return CounparRootSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> mergeHook(List<OwnparInfo> baseInfos, List<CounparInfo> selectedInfos) {	
		return OwnparMerger.mergeWithCounpar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
