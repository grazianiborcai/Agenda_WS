package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.EmpwotmRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmVisiRootSelect extends ActionVisitorTemplateAction<EmpwotmInfo, EmpwotmInfo> {

	public EmpwotmVisiRootSelect(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotmInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return EmpwotmRootSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> toBaseClassHook(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> results) {
		return results;
	}
}
