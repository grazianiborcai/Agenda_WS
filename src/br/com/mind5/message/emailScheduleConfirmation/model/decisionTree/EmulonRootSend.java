package br.com.mind5.message.emailScheduleConfirmation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiEnforceEmabody;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiMergeCuslis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiMergeEmplis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiMergeMatlis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiMergeStolis;
import br.com.mind5.message.emailScheduleConfirmation.model.action.EmulonVisiSendEmail;
import br.com.mind5.message.emailScheduleConfirmation.model.checker.EmulonCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmulonRootSend extends DeciTreeTemplateWrite<EmulonInfo> {
	
	public EmulonRootSend(DeciTreeOption<EmulonInfo> option) {
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
		
		ActionStd<EmulonInfo> mergeStolis = new ActionStdCommom<EmulonInfo>(option, EmulonVisiMergeStolis.class);
		ActionLazy<EmulonInfo> mergeCuslis = new ActionLazyCommom<EmulonInfo>(option, EmulonVisiMergeCuslis.class);	
		ActionLazy<EmulonInfo> mergeMatlis = new ActionLazyCommom<EmulonInfo>(option, EmulonVisiMergeMatlis.class);	
		ActionLazy<EmulonInfo> mergeEmplis = new ActionLazyCommom<EmulonInfo>(option, EmulonVisiMergeEmplis.class);	
		ActionLazy<EmulonInfo> enforceEmabody = new ActionLazyCommom<EmulonInfo>(option, EmulonVisiEnforceEmabody.class);		
		ActionLazy<EmulonInfo> send = new ActionLazyCommom<EmulonInfo>(option, EmulonVisiSendEmail.class);
		
		mergeStolis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
