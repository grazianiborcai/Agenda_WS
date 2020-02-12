package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.mind5.payment.creditCard.model.action.StdCrecardEnforceLChanged;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDummy;

public final class NodeCrecardUser extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardUser(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	

		checker = new CrecardCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> enforceLChanged = new StdCrecardEnforceLChanged(option);	
		ActionLazy<CrecardInfo> mergeUsername = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeUsername);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
