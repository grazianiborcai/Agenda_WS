package br.com.mind5.message.emailBody.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.model.action.LazyEmabodyEnforceBody;
import br.com.mind5.message.emailBody.model.action.StdEmabodyMergeToSelect;
import br.com.mind5.message.emailBody.model.checker.EmabodyCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmabodySelect extends DeciTreeWriteTemplate<EmabodyInfo> {
	
	public RootEmabodySelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmabodyInfo> buildDecisionCheckerHook(DeciTreeOption<EmabodyInfo> option) {		
		List<ModelChecker<EmabodyInfo>> queue = new ArrayList<>();		
		ModelChecker<EmabodyInfo> checker;	
		
		checker = new EmabodyCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmabodyInfo>> buildActionsOnPassedHook(DeciTreeOption<EmabodyInfo> option) {
		List<ActionStd<EmabodyInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmabodyInfo> select = new StdEmabodyMergeToSelect(option);
		ActionLazy<EmabodyInfo> enforceBody = new LazyEmabodyEnforceBody(option.conn, option.schemaName);
		
		select.addPostAction(enforceBody);
		
		actions.add(select);		
		return actions;
	}
}
