package br.com.mind5.business.calendarMonthSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.decisionTree.CalontharchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiRootSelect extends ActionVisitorTemplateAction<CalontharchInfo, CalontharchInfo> {

	public CalontharchVisiRootSelect(DeciTreeOption<CalontharchInfo> option) {
		super(option, CalontharchInfo.class, CalontharchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalontharchInfo>> getTreeClassHook() {
		return CalontharchRootSelect.class;
	}
	
	
	
	@Override protected List<CalontharchInfo> toBaseClassHook(List<CalontharchInfo> baseInfos, List<CalontharchInfo> results) {
		return results;
	}
}
