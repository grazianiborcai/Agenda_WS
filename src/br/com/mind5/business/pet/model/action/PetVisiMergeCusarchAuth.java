package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.CusarchRootSelectAuth;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergeCusarchAuth extends ActionVisitorTemplateMerge<PetInfo, CusarchInfo> {
	
	public PetVisiMergeCusarchAuth(DeciTreeOption<PetInfo> option) {
		super(option, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return CusarchRootSelectAuth.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<CusarchInfo> selectedInfos) {	
		return PetMerger.mergeWithCusarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
