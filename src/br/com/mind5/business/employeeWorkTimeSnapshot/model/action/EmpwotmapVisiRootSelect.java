package br.com.mind5.business.employeeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.decisionTree.EmpwotmapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmapVisiRootSelect extends ActionVisitorTemplateAction<EmpwotmapInfo, EmpwotmapInfo> {

	public EmpwotmapVisiRootSelect(DeciTreeOption<EmpwotmapInfo> option) {
		super(option, EmpwotmapInfo.class, EmpwotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmapInfo>> getTreeClassHook() {
		return EmpwotmapRootSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmapInfo> toBaseClassHook(List<EmpwotmapInfo> baseInfos, List<EmpwotmapInfo> results) {
		return results;
	}
}
