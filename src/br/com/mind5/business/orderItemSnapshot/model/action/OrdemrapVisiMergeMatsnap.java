package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapCopier;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemrapVisiMergeMatsnap extends ActionVisitorTemplateMerge<OrdemrapInfo, MatsnapInfo> {
	
	public OrdemrapVisiMergeMatsnap(DeciTreeOption<OrdemrapInfo> option) {
		super(option, MatsnapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return RootMatsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<OrdemrapInfo> baseInfos) {
		return MatsnapCopier.copyFromOrdemrap(baseInfos);	
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithMatsnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
