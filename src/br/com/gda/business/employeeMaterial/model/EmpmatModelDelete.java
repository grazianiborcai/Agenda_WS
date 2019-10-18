package br.com.gda.business.employeeMaterial.model;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.decisionTree.RootEmpmatDelete;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpmatModelDelete extends ModelTemplate<EmpmatInfo> {

	public EmpmatModelDelete(EmpmatInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpmatInfo> getDecisionTreeHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
