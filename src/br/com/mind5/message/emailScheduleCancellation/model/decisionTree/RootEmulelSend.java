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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmulelSend extends DeciTreeTemplateWriteV2<EmulelInfo> {
	
	public RootEmulelSend(DeciTreeOption<EmulelInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmulelInfo> buildCheckerHook(DeciTreeOption<EmulelInfo> option) {		
		List<ModelCheckerV1<EmulelInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmulelInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmulelCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmulelInfo>> buildActionsOnPassedHook(DeciTreeOption<EmulelInfo> option) {
		List<ActionStdV1<EmulelInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmulelInfo> mergeStolis = new StdEmulelMergeStolis(option);
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
