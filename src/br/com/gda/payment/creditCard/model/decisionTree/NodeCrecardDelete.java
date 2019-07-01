package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardDelete;
import br.com.gda.payment.creditCard.model.action.StdCrecardUpdate;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckUserCuspar;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCrecardDelete extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		
		checker = new CrecardCheckUserCuspar();
		queue.add(checker);

		return new ModelCheckerQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> deleteMoip = new NodeCrecardDeleteMoip(option).toAction();
		ActionStd<CrecardInfo> update = new StdCrecardUpdate(option);
		ActionLazy<CrecardInfo> delete = new LazyCrecardDelete(option.conn, option.schemaName);
		
		update.addPostAction(delete);
		
		actions.add(deleteMoip);
		actions.add(update);		
		
		return actions;
	}
}
