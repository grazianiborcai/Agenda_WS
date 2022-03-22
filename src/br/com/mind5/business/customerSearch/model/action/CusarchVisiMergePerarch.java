package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectCus;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiMergePerarch extends ActionVisitorTemplateMerge<CusarchInfo, PerarchInfo> {
	
	public CusarchVisiMergePerarch(DeciTreeOption<CusarchInfo> option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return RootPerarchSelectCus.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<PerarchInfo> selectedInfos) {	
		return CusarchMerger.mergeWithPerarch(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<CusarchInfo> baseInfos) {
		return PerarchCopier.copyFromCusarch(baseInfos);	
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
