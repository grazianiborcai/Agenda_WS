package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.EmpNodePersonUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiNodePersonUpdate extends ActionVisitorTemplateAction<EmpInfo, EmpInfo> {

	public EmpVisiNodePersonUpdate(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return EmpNodePersonUpdate.class;
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpInfo> results) {
		return results;
	}
}
