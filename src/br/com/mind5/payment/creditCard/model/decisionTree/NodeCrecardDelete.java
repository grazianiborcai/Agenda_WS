package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardDaoDelete;
import br.com.mind5.payment.creditCard.model.action.StdCrecardDaoUpdate;

public final class NodeCrecardDelete extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public NodeCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> deleteMoip = new NodeCrecardDeleteMoip(option).toAction();
		ActionStd<CrecardInfo> update = new StdCrecardDaoUpdate(option);
		ActionLazy<CrecardInfo> delete = new LazyCrecardDaoDelete(option.conn, option.schemaName);
		
		update.addPostAction(delete);
		
		actions.add(deleteMoip);
		actions.add(update);		
		
		return actions;
	}
}
