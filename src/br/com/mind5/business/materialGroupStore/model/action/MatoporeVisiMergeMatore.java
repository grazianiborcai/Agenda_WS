package br.com.mind5.business.materialGroupStore.model.action;

import java.util.List;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeMerger;
import br.com.mind5.business.materialStore.info.MatoreCopier;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoporeVisiMergeMatore extends ActionVisitorTemplateMerge<MatoporeInfo, MatoreInfo> {
	
	public MatoporeVisiMergeMatore(DeciTreeOption<MatoporeInfo> option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSearch.class;
	}
	
	
	
	@Override protected List<MatoreInfo> toActionClassHook(List<MatoporeInfo> baseInfos) {
		return MatoreCopier.copyFromMatopore(baseInfos);	
	}
	
	
	
	@Override protected List<MatoporeInfo> mergeHook(List<MatoporeInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return MatoporeMerger.mergeWithMatore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
