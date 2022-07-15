package br.com.mind5.payment.countryPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparMerger;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.decisionTree.RootCounparchSelect;

public final class CounparVisiMergeCounparch extends ActionVisitorTemplateMerge<CounparInfo, CounparchInfo> {
	
	public CounparVisiMergeCounparch(DeciTreeOption<CounparInfo> option) {
		super(option, CounparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparchInfo>> getTreeClassHook() {
		return RootCounparchSelect.class;
	}
	
	
	
	@Override protected List<CounparInfo> mergeHook(List<CounparInfo> baseInfos, List<CounparchInfo> selectedInfos) {
		return CounparMerger.mergeWithCounparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
