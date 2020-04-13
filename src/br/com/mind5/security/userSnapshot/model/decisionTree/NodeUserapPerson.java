package br.com.mind5.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.StdUserapMergePersolis;
import br.com.mind5.security.userSnapshot.model.action.StdUserapSuccess;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckHasPerson;

public final class NodeUserapPerson extends DeciTreeTemplateWriteV1<UserapInfo> {
	
	public NodeUserapPerson(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserapInfo> buildCheckerHook(DeciTreeOption<UserapInfo> option) {
		List<ModelCheckerV1<UserapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserapCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserapInfo>> buildActionsOnPassedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStdV1<UserapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<UserapInfo> mergePersolis = new StdUserapMergePersolis(option);
		
		actions.add(mergePersolis);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<UserapInfo>> buildActionsOnFailedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStdV1<UserapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<UserapInfo> success = new StdUserapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
