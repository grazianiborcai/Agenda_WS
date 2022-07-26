package br.com.mind5.message.emailWelcome.model.action;

import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.decisionTree.EmacomeNodeSend;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmacomeVisiNodeSend extends ActionVisitorTemplateAction<EmacomeInfo, EmacomeInfo> {

	public EmacomeVisiNodeSend(DeciTreeOption<EmacomeInfo> option) {
		super(option, EmacomeInfo.class, EmacomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmacomeInfo>> getTreeClassHook() {
		return EmacomeNodeSend.class;
	}
	
	
	
	@Override protected List<EmacomeInfo> toBaseClassHook(List<EmacomeInfo> baseInfos, List<EmacomeInfo> results) {
		return results;
	}
}
