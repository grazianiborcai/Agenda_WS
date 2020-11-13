package br.com.mind5.message.emailPasswordChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.model.action.LazyEmordeEnforceEmabody;
import br.com.mind5.message.emailPasswordChange.model.action.LazyEmordeSendEmail;
import br.com.mind5.message.emailPasswordChange.model.action.StdEmordeMergeUselis;
import br.com.mind5.message.emailPasswordChange.model.checker.EmordeCheckSend;
import br.com.mind5.message.emailPasswordChange.model.checker.EmordeCheckUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmordeSend extends DeciTreeTemplateWrite<EmordeInfo> {
	
	public RootEmordeSend(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmordeInfo> buildCheckerHook(DeciTreeOption<EmordeInfo> option) {		
		List<ModelChecker<EmordeInfo>> queue = new ArrayList<>();		
		ModelChecker<EmordeInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmordeCheckSend(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmordeCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmordeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmordeInfo> option) {
		List<ActionStd<EmordeInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmordeInfo> mergeUselis = new StdEmordeMergeUselis(option);
		ActionLazy<EmordeInfo> enforceEmabody = new LazyEmordeEnforceEmabody(option.conn, option.schemaName);
		ActionLazy<EmordeInfo> send = new LazyEmordeSendEmail(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeUselis);		
		return actions;
	}
}
