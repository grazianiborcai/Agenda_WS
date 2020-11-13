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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmordeSend extends DeciTreeTemplateWriteV2<EmordeInfo> {
	
	public RootEmordeSend(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmordeInfo> buildCheckerHook(DeciTreeOption<EmordeInfo> option) {		
		List<ModelCheckerV1<EmordeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmordeInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmordeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmordeInfo> option) {
		List<ActionStdV1<EmordeInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmordeInfo> mergeUselis = new StdEmordeMergeUselis(option);
		ActionLazy<EmordeInfo> enforceEmabody = new LazyEmordeEnforceEmabody(option.conn, option.schemaName);
		ActionLazy<EmordeInfo> send = new LazyEmordeSendEmail(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeUselis);		
		return actions;
	}
}
