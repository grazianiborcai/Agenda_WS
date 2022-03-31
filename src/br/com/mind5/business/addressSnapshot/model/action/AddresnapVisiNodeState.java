package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.AddresnapNodeState;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiNodeState extends ActionVisitorTemplateAction<AddresnapInfo, AddresnapInfo> {

	public AddresnapVisiNodeState(DeciTreeOption<AddresnapInfo> option) {
		super(option, AddresnapInfo.class, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return AddresnapNodeState.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toBaseClassHook(List<AddresnapInfo> baseInfos, List<AddresnapInfo> results) {
		return results;
	}
}
