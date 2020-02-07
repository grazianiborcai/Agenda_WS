package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeCuspar;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeSelect;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeToSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckCuspar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckRead;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardSelect extends DeciTreeReadTemplate<CrecardInfo> {
	
	public RootCrecardSelect(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckCuspar(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> mergeToSelect = new StdCrecardMergeToSelect(option);
		ActionLazy<CrecardInfo> mergeUsername = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> mergeCuspar = new LazyCrecardMergeCuspar(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodeSelect = new LazyCrecardNodeSelect(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(nodeSelect);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
