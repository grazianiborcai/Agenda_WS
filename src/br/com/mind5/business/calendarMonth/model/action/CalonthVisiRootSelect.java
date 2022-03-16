package br.com.mind5.business.calendarMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthVisiRootSelect extends ActionVisitorTemplateAction<CalonthInfo, CalonthInfo> {

	public CalonthVisiRootSelect(DeciTreeOption<CalonthInfo> option) {
		super(option, CalonthInfo.class, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<CalonthInfo> toBaseClassHook(List<CalonthInfo> baseInfos, List<CalonthInfo> results) {
		return results;
	}
}
