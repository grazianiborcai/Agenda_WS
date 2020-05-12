package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdNodeEmailL2;
import br.com.mind5.security.userPassword.model.action.StdUpswdMergeUser;

public final class NodeUpswdEmailL1 extends DeciTreeTemplateWriteV2<UpswdInfo> {
	
	public NodeUpswdEmailL1(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelCheckerV1<UpswdInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UpswdInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> mergeUser = new StdUpswdMergeUser(option);
		ActionLazyV1<UpswdInfo> nodeL2 = new LazyUpswdNodeEmailL2(option.conn, option.schemaName);
		
		mergeUser.addPostAction(nodeL2);
		
		actions.add(mergeUser);		
		return actions;
	}
}
