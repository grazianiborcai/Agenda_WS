package br.com.mind5.message.emailProspectStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailProspectStore.info.EmaproreInfo;
import br.com.mind5.message.emailProspectStore.model.action.LazyEmaproreSendEmail;
import br.com.mind5.message.emailProspectStore.model.action.StdEmaproreEnforceEmabody;
import br.com.mind5.message.emailProspectStore.model.checker.EmaproreCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmaproreSend extends DeciTreeTemplateWriteV2<EmaproreInfo> {
	
	public RootEmaproreSend(DeciTreeOption<EmaproreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmaproreInfo> buildCheckerHook(DeciTreeOption<EmaproreInfo> option) {		
		List<ModelCheckerV1<EmaproreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmaproreInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmaproreCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmaproreInfo>> buildActionsOnPassedHook(DeciTreeOption<EmaproreInfo> option) {
		List<ActionStdV1<EmaproreInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmaproreInfo> enforceEmabody = new StdEmaproreEnforceEmabody(option);
		ActionLazy<EmaproreInfo> send = new LazyEmaproreSendEmail(option.conn, option.schemaName);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
