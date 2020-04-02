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
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();		

		ActionStdV1<CrecardInfo> enforceLChanged = new StdCrecardEnforceLChanged(option);	
		ActionLazyV1<CrecardInfo> mergeUsername = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeUsername);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
