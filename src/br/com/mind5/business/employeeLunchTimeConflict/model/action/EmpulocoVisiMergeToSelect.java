package br.com.mind5.business.employeeLunchTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoInfo;
import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpulocoVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpulocoInfo, EmpulocoInfo> {
	
	public EmpulocoVisiMergeToSelect(DeciTreeOption<EmpulocoInfo> option) {
		super(option, EmpulocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpulocoInfo>> getVisitorClassHook() {
		return EmpulocoVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpulocoInfo> mergeHook(List<EmpulocoInfo> baseInfos, List<EmpulocoInfo> selectedInfos) {	
		return EmpulocoMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
