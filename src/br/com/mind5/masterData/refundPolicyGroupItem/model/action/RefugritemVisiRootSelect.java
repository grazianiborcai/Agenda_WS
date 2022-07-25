package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree.RefugritemRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritemVisiRootSelect extends ActionVisitorTemplateAction<RefugritemInfo, RefugritemInfo> {

	public RefugritemVisiRootSelect(DeciTreeOption<RefugritemInfo> option) {
		super(option, RefugritemInfo.class, RefugritemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugritemInfo>> getTreeClassHook() {
		return RefugritemRootSelect.class;
	}
	
	
	
	@Override protected List<RefugritemInfo> toBaseClassHook(List<RefugritemInfo> baseInfos, List<RefugritemInfo> results) {
		return results;
	}
}
