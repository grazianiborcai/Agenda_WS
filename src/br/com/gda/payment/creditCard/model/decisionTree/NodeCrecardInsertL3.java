package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardNodeInsertL4;
import br.com.gda.payment.creditCard.model.action.StdCrecardMergeCuspar;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckCuspar;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckUserRef;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCrecardInsertL3 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardInsertL3(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CrecardCheckUserRef();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckCuspar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();	
		
		ActionStd<CrecardInfo> mergeCuspar = new StdCrecardMergeCuspar(option);	
		ActionLazy<CrecardInfo> nodeInsertL4 = new LazyCrecardNodeInsertL4(option.conn, option.schemaName);	
		
		mergeCuspar.addPostAction(nodeInsertL4);
		
		actions.add(mergeCuspar);		
		return actions;
	}
}
