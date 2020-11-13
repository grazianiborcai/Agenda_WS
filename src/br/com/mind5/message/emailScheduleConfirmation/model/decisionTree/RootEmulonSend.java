package br.com.mind5.message.emailScheduleConfirmation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.model.action.LazyEmulonEnforceEmabody;
import br.com.mind5.message.emailScheduleConfirmation.model.action.LazyEmulonMergeCuslis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.LazyEmulonMergeEmplis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.LazyEmulonMergeMatlis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.LazyEmulonSendEmail;
import br.com.mind5.message.emailScheduleConfirmation.model.action.StdEmulonMergeStolis;
import br.com.mind5.message.emailScheduleConfirmation.model.checker.EmulonCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmulonSend extends DeciTreeTemplateWrite<EmulonInfo> {
	
	public RootEmulonSend(DeciTreeOption<EmulonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmulonInfo> buildCheckerHook(DeciTreeOption<EmulonInfo> option) {		
		List<ModelChecker<EmulonInfo>> queue = new ArrayList<>();		
		ModelChecker<EmulonInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmulonCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmulonInfo>> buildActionsOnPassedHook(DeciTreeOption<EmulonInfo> option) {
		List<ActionStd<EmulonInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmulonInfo> mergeStolis = new StdEmulonMergeStolis(option);
		ActionLazy<EmulonInfo> mergeCuslis = new LazyEmulonMergeCuslis(option.conn, option.schemaName);	
		ActionLazy<EmulonInfo> mergeMatlis = new LazyEmulonMergeMatlis(option.conn, option.schemaName);	
		ActionLazy<EmulonInfo> mergeEmplis = new LazyEmulonMergeEmplis(option.conn, option.schemaName);	
		ActionLazy<EmulonInfo> enforceEmabody = new LazyEmulonEnforceEmabody(option.conn, option.schemaName);		
		ActionLazy<EmulonInfo> send = new LazyEmulonSendEmail(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
