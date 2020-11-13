package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.StdNotesSuccess;
import br.com.mind5.business.notes.model.checker.NotesCheckHasCustomer;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeNotesCustomerL1 extends DeciTreeTemplateWrite<NotesInfo> {
	
	public NodeNotesCustomerL1(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<NotesInfo> buildCheckerHook(DeciTreeOption<NotesInfo> option) {
		List<ModelChecker<NotesInfo>> queue = new ArrayList<>();		
		ModelChecker<NotesInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new NotesCheckHasCustomer(checkerOption);

		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStd<NotesInfo>> actions = new ArrayList<>();
		
		ActionStd<NotesInfo> nodeL2 = new NodeNotesCustomerL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<NotesInfo>> buildActionsOnFailedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStd<NotesInfo>> actions = new ArrayList<>();
		
		ActionStd<NotesInfo> success = new StdNotesSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
