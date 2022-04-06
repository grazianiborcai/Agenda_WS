package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.EmpmatNodeInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiNodeInsert extends ActionVisitorTemplateAction<EmpmatInfo, EmpmatInfo> {

	public EmpmatVisiNodeInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmatInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return EmpmatNodeInsert.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> toBaseClassHook(List<EmpmatInfo> baseInfos, List<EmpmatInfo> results) {
		return results;
	}
}
