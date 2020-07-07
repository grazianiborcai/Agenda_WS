package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.StdNotesSuccess;
import br.com.mind5.business.notes.model.checker.NotesCheckHasCustomer;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeNotesCustomerL1 extends DeciTreeTemplateWriteV2<NotesInfo> {
	
	public NodeNotesCustomerL1(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<NotesInfo> buildCheckerHook(DeciTreeOption<NotesInfo> option) {
		List<ModelCheckerV1<NotesInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<NotesInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new NotesCheckHasCustomer(checkerOption);

		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStdV1<NotesInfo>> actions = new ArrayList<>();
		
		ActionStdV1<NotesInfo> nodeL2 = new NodeNotesCustomerL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<NotesInfo>> buildActionsOnFailedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStdV1<NotesInfo>> actions = new ArrayList<>();
		
		ActionStdV1<NotesInfo> success = new StdNotesSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
