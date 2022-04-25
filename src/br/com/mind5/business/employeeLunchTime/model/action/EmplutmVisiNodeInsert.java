package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmNodeInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiNodeInsert extends ActionVisitorTemplateAction<EmplutmInfo, EmplutmInfo> {

	public EmplutmVisiNodeInsert(DeciTreeOption<EmplutmInfo> option) {
		super(option, EmplutmInfo.class, EmplutmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmInfo>> getTreeClassHook() {
		return EmplutmNodeInsert.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> toBaseClassHook(List<EmplutmInfo> baseInfos, List<EmplutmInfo> results) {
		return results;
	}
}
