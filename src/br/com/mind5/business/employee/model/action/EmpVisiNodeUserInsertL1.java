package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.EmpNodeUserInsertL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiNodeUserInsertL1 extends ActionVisitorTemplateAction<EmpInfo, EmpInfo> {

	public EmpVisiNodeUserInsertL1(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return EmpNodeUserInsertL1.class;
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpInfo> results) {
		return results;
	}
}
