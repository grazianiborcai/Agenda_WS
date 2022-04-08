package br.com.mind5.business.materialTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.info.MatextaultMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextaultVisiMergeToSelect extends ActionVisitorTemplateMerge<MatextaultInfo, MatextaultInfo> {
	
	public MatextaultVisiMergeToSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatextaultInfo>> getVisitorClassHook() {
		return MatextaultVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextaultInfo> toActionClassHook(List<MatextaultInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextaultInfo> mergeHook(List<MatextaultInfo> baseInfos, List<MatextaultInfo> selectedInfos) {	
		return MatextaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
