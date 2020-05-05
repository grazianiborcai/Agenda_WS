package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardDaoDelete;
import br.com.mind5.payment.creditCard.model.action.StdCrecardDaoUpdate;

public final class NodeCrecardDelete extends DeciTreeTemplateWriteV2<CrecardInfo> {
	
	public NodeCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CrecardInfo> deleteMoip = new NodeCrecardDeleteMoip(option).toAction();
		ActionStdV1<CrecardInfo> update = new StdCrecardDaoUpdate(option);
		ActionLazyV1<CrecardInfo> delete = new LazyCrecardDaoDelete(option.conn, option.schemaName);
		
		update.addPostAction(delete);
		
		actions.add(deleteMoip);
		actions.add(update);		
		
		return actions;
	}
}
