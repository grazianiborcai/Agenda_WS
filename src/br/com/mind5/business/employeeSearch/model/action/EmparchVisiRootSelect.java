package br.com.mind5.business.employeeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.EmparchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmparchVisiRootSelect extends ActionVisitorTemplateAction<EmparchInfo, EmparchInfo> {

	public EmparchVisiRootSelect(DeciTreeOption<EmparchInfo> option) {
		super(option, EmparchInfo.class, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmparchInfo>> getTreeClassHook() {
		return EmparchRootSelect.class;
	}
	
	
	
	@Override protected List<EmparchInfo> toBaseClassHook(List<EmparchInfo> baseInfos, List<EmparchInfo> results) {
		return results;
	}
}
