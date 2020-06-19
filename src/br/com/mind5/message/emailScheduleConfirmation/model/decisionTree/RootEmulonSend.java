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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmulonSend extends DeciTreeTemplateWriteV2<EmulonInfo> {
	
	public RootEmulonSend(DeciTreeOption<EmulonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmulonInfo> buildCheckerHook(DeciTreeOption<EmulonInfo> option) {		
		List<ModelCheckerV1<EmulonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmulonInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmulonCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmulonInfo>> buildActionsOnPassedHook(DeciTreeOption<EmulonInfo> option) {
		List<ActionStdV1<EmulonInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmulonInfo> mergeStolis = new StdEmulonMergeStolis(option);
		ActionLazyV1<EmulonInfo> mergeCuslis = new LazyEmulonMergeCuslis(option.conn, option.schemaName);	
		ActionLazyV1<EmulonInfo> mergeMatlis = new LazyEmulonMergeMatlis(option.conn, option.schemaName);	
		ActionLazyV1<EmulonInfo> mergeEmplis = new LazyEmulonMergeEmplis(option.conn, option.schemaName);	
		ActionLazyV1<EmulonInfo> enforceEmabody = new LazyEmulonEnforceEmabody(option.conn, option.schemaName);		
		ActionLazyV1<EmulonInfo> send = new LazyEmulonSendEmail(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
