package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.decisionTree.EmpwotmapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmVisiEmpwotmapInsert extends ActionVisitorTemplateAction<EmpwotmInfo, EmpwotmapInfo> {

	public EmpwotmVisiEmpwotmapInsert(DeciTreeOption<EmpwotmInfo> option) {
		super(option, EmpwotmInfo.class, EmpwotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmapInfo>> getTreeClassHook() {
		return EmpwotmapRootInsert.class;
	}
	
	
	
	protected List<EmpwotmInfo> toBaseClassHook(List<EmpwotmInfo> baseInfos, List<EmpwotmapInfo> selectedInfos) {
		return EmpwotmMerger.mergeWithEmpwotmap(baseInfos, selectedInfos);
	}
}
