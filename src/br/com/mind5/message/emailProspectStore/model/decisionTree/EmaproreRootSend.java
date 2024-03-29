package br.com.mind5.message.emailProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.model.action.EmaproreVisiEnforceEmabody;
import br.com.mind5.message.emailProspectStore.model.action.EmaproreVisiSendEmail;
import br.com.mind5.message.emailProspectStore.model.checker.EmaproreCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmaproreRootSend extends DeciTreeTemplateWrite<EmaproreInfo> {
	
	public EmaproreRootSend(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmaproreInfo> buildCheckerHook(DeciTreeOption<EmaproreInfo> option) {		
		List<ModelChecker<EmaproreInfo>> queue = new ArrayList<>();		
		ModelChecker<EmaproreInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmaproreCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmaproreInfo>> buildActionsOnPassedHook(DeciTreeOption<EmaproreInfo> option) {
		List<ActionStd<EmaproreInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmaproreInfo> enforceEmabody = new ActionStdCommom<EmaproreInfo>(option, EmaproreVisiEnforceEmabody.class);
		ActionLazy<EmaproreInfo> send = new ActionLazyCommom<EmaproreInfo>(option, EmaproreVisiSendEmail.class);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
