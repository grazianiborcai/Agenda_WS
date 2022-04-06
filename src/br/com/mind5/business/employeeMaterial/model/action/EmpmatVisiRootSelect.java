package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.EmpmatRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiRootSelect extends ActionVisitorTemplateAction<EmpmatInfo, EmpmatInfo> {

	public EmpmatVisiRootSelect(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmatInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return EmpmatRootSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> toBaseClassHook(List<EmpmatInfo> baseInfos, List<EmpmatInfo> results) {
		return results;
	}
}
