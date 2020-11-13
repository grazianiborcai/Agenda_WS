package br.com.mind5.message.emailScheduleCancellation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.model.action.LazyEmulelEnforceEmabody;
import br.com.mind5.message.emailScheduleCancellation.model.action.LazyEmulelMergeCuslis;
import br.com.mind5.message.emailScheduleCancellation.model.action.LazyEmulelMergeEmplis;
import br.com.mind5.message.emailScheduleCancellation.model.action.LazyEmulelMergeMatlis;
import br.com.mind5.message.emailScheduleCancellation.model.action.LazyEmulelSendEmail;
import br.com.mind5.message.emailScheduleCancellation.model.action.StdEmulelMergeStolis;
import br.com.mind5.message.emailScheduleCancellation.model.checker.EmulelCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmulelSend extends DeciTreeTemplateWrite<EmulelInfo> {
	
	public RootEmulelSend(DeciTreeOption<EmulelInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmulelInfo> buildCheckerHook(DeciTreeOption<EmulelInfo> option) {		
		List<ModelChecker<EmulelInfo>> queue = new ArrayList<>();		
		ModelChecker<EmulelInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmulelCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmulelInfo>> buildActionsOnPassedHook(DeciTreeOption<EmulelInfo> option) {
		List<ActionStd<EmulelInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmulelInfo> mergeStolis = new StdEmulelMergeStolis(option);
		ActionLazy<EmulelInfo> mergeCuslis = new LazyEmulelMergeCuslis(option.conn, option.schemaName);	
		ActionLazy<EmulelInfo> mergeMatlis = new LazyEmulelMergeMatlis(option.conn, option.schemaName);	
		ActionLazy<EmulelInfo> mergeEmplis = new LazyEmulelMergeEmplis(option.conn, option.schemaName);	
		ActionLazy<EmulelInfo> enforceEmabody = new LazyEmulelEnforceEmabody(option.conn, option.schemaName);		
		ActionLazy<EmulelInfo> send = new LazyEmulelSendEmail(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
