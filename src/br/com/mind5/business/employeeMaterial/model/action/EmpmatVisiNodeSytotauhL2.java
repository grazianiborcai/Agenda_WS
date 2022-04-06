package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.EmpmatNodeSytotauhL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiNodeSytotauhL2 extends ActionVisitorTemplateAction<EmpmatInfo, EmpmatInfo> {

	public EmpmatVisiNodeSytotauhL2(DeciTreeOption<EmpmatInfo> option) {
		super(option, EmpmatInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return EmpmatNodeSytotauhL2.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> toBaseClassHook(List<EmpmatInfo> baseInfos, List<EmpmatInfo> results) {
		return results;
	}
}
