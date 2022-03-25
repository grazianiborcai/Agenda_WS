package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.EmpwotmRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmVisiRootDelete extends ActionVisitorTemplateAction<EmpwotmInfo, EmpwotmInfo> {

	public EmpwotmVisiRootDelete(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotmInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return EmpwotmRootDelete.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> toBaseClassHook(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> results) {
		return results;
	}
}
