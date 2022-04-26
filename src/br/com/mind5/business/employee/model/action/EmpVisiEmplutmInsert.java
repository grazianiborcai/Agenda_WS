package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmCopier;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiEmplutmInsert extends ActionVisitorTemplateAction<EmpInfo, EmplutmInfo> {
	
	public EmpVisiEmplutmInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmplutmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmInfo>> getTreeClassHook() {
		return EmplutmRootInsert.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return EmplutmCopier.copyFromEmp(recordInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmplutmInfo> results) {
		return baseInfos;	
	}
}
