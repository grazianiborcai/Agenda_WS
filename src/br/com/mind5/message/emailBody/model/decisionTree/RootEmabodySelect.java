package br.com.mind5.message.emailBody.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.model.action.LazyEmabodyEnforceBody;
import br.com.mind5.message.emailBody.model.action.StdEmabodyMergeToSelect;
import br.com.mind5.message.emailBody.model.checker.EmabodyCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmabodySelect extends DeciTreeWriteTemplate<EmabodyInfo> {
	
	public RootEmabodySelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmabodyInfo> buildCheckerHook(DeciTreeOption<EmabodyInfo> option) {		
		List<ModelChecker<EmabodyInfo>> queue = new ArrayList<>();		
		ModelChecker<EmabodyInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmabodyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmabodyInfo>> buildActionsOnPassedHook(DeciTreeOption<EmabodyInfo> option) {
		List<ActionStdV1<EmabodyInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmabodyInfo> select = new StdEmabodyMergeToSelect(option);
		ActionLazyV1<EmabodyInfo> enforceBody = new LazyEmabodyEnforceBody(option.conn, option.schemaName);
		
		select.addPostAction(enforceBody);
		
		actions.add(select);		
		return actions;
	}
}
