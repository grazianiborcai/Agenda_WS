package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.SymsgNodeSelectL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgVisiNodeSelectL2 extends ActionVisitorTemplateAction<SymsgInfo, SymsgInfo> {

	public SymsgVisiNodeSelectL2(DeciTreeOption<SymsgInfo> option) {
		super(option, SymsgInfo.class, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SymsgInfo>> getTreeClassHook() {
		return SymsgNodeSelectL2.class;
	}
	
	
	
	@Override protected List<SymsgInfo> toBaseClassHook(List<SymsgInfo> baseInfos, List<SymsgInfo> results) {
		return results;
	}
}
