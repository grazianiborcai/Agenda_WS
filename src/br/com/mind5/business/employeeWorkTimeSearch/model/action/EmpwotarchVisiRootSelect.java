package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.EmpwotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotarchVisiRootSelect extends ActionVisitorTemplateAction<EmpwotarchInfo, EmpwotarchInfo> {

	public EmpwotarchVisiRootSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option, EmpwotarchInfo.class, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotarchInfo>> getTreeClassHook() {
		return EmpwotarchRootSelect.class;
	}
	
	
	
	@Override protected List<EmpwotarchInfo> toBaseClassHook(List<EmpwotarchInfo> baseInfos, List<EmpwotarchInfo> results) {
		return results;
	}
}
