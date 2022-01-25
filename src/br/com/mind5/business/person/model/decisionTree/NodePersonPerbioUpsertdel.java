package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonPerbioUpsertdel;
import br.com.mind5.business.person.model.action.StdPersonEnforcePerbioKey;
import br.com.mind5.business.person.model.action.StdPersonSuccess;
import br.com.mind5.business.person.model.checker.PersonCheckHasPerbio;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodePersonPerbioUpsertdel extends DeciTreeTemplateWrite<PersonInfo> {
	
	public NodePersonPerbioUpsertdel(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckHasPerbio(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> enforcePerbioKe = new StdPersonEnforcePerbioKey(option);
		ActionLazy<PersonInfo> perbioUpsertdel = new LazyPersonPerbioUpsertdel(option.conn, option.schemaName);
		
		enforcePerbioKe.addPostAction(perbioUpsertdel);
		
		actions.add(enforcePerbioKe);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> success = new StdPersonSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
