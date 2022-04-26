package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmCopier;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.EmpwotmRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiEmpwotmUpsertdel extends ActionVisitorTemplateAction<EmpInfo, EmpwotmInfo> {
	
	public EmpVisiEmpwotmUpsertdel(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return EmpwotmRootUpsertdel.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return EmpwotmCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpwotmInfo> results) {
		return baseInfos;	
	}
}
