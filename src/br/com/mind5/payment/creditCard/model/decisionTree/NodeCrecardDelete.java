package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardDelete;
import br.com.mind5.payment.creditCard.model.action.StdCrecardUpdate;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDummy;

public final class NodeCrecardDelete extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;

		checker = new CrecardCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CrecardInfo> deleteMoip = new NodeCrecardDeleteMoip(option).toAction();
		ActionStdV1<CrecardInfo> update = new StdCrecardUpdate(option);
		ActionLazyV1<CrecardInfo> delete = new LazyCrecardDelete(option.conn, option.schemaName);
		
		update.addPostAction(delete);
		
		actions.add(deleteMoip);
		actions.add(update);		
		
		return actions;
	}
}
