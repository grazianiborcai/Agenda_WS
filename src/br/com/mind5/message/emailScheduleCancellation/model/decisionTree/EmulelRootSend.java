package br.com.mind5.message.emailScheduleCancellation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiEnforceEmabody;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiMergeCuslis;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiMergeEmplis;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiMergeMatlis;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiMergeStolis;
import br.com.mind5.message.emailScheduleCancellation.model.action.EmulelVisiSendEmail;
import br.com.mind5.message.emailScheduleCancellation.model.checker.EmulelCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmulelRootSend extends DeciTreeTemplateWrite<EmulelInfo> {
	
	public EmulelRootSend(DeciTreeOption<EmulelInfo> option) {
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
		
		ActionStd<EmulelInfo> mergeStolis = new ActionStdCommom<EmulelInfo>(option, EmulelVisiMergeStolis.class);
		ActionLazy<EmulelInfo> mergeCuslis = new ActionLazyCommom<EmulelInfo>(option, EmulelVisiMergeCuslis.class);	
		ActionLazy<EmulelInfo> mergeMatlis = new ActionLazyCommom<EmulelInfo>(option, EmulelVisiMergeMatlis.class);	
		ActionLazy<EmulelInfo> mergeEmplis = new ActionLazyCommom<EmulelInfo>(option, EmulelVisiMergeEmplis.class);	
		ActionLazy<EmulelInfo> enforceEmabody = new ActionLazyCommom<EmulelInfo>(option, EmulelVisiEnforceEmabody.class);		
		ActionLazy<EmulelInfo> send = new ActionLazyCommom<EmulelInfo>(option, EmulelVisiSendEmail.class);
		
		mergeStolis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
