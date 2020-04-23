package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.RootEmpmatDeleteByEmp;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteEmpmat extends ActionVisitorTemplateActionV2<EmpInfo, EmpmatInfo> {
	public VisiEmpDeleteEmpmat(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return RootEmpmatDeleteByEmp.class;
	}
}
