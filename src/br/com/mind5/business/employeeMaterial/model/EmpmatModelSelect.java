package br.com.mind5.business.employeeMaterial.model;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.RootEmpmatSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatModelSelect extends ModelTemplate<EmpmatInfo> {

	public EmpmatModelSelect(EmpmatInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpmatInfo> getDecisionTreeHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
